package com.example.samplemvvmkotlin.Interface;

import com.example.samplemvvmkotlin.model.dataModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestAPI {
    @GET("comments")
    Call<List<dataModel>> getDataModel();
}
