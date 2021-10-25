package com.example.samplemvvmkotlin.model;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.samplemvvmkotlin.Interface.RestAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainViewModel extends ViewModel {

    MutableLiveData<List<dataModel>> userLiveData;
    List<dataModel> dataModels;


    public MainViewModel() {
        userLiveData = new MutableLiveData<>();
        init();
    }

    public MutableLiveData<List<dataModel>> getUserMutableLiveData() {
        return userLiveData;
    }

    public void init(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RestAPI restAPI = retrofit.create(RestAPI.class);

        Call<List<dataModel>> call = restAPI.getDataModel();

        call.enqueue(new Callback<List<dataModel>>() {
            @Override
            public void onResponse(Call<List<dataModel>> call, Response<List<dataModel>> response) {
                dataModels = response.body();
                userLiveData.setValue(dataModels);
            }

            @Override
            public void onFailure(Call<List<dataModel>> call, Throwable t) {
                Log.d("TAG", "onFailure: "+ "There is a problem");
            }
        });
    }
}
