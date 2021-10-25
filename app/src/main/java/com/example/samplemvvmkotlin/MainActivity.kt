package com.example.samplemvvmkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.samplemvvmkotlin.adapter.listAdapter
import com.example.samplemvvmkotlin.model.MainViewModel
import com.example.samplemvvmkotlin.model.dataModel

class MainActivity : AppCompatActivity() {
    var context: MainActivity? = null
    var viewModel: MainViewModel? = null
    var recyclerView: RecyclerView? = null
    var recyclerViewAdapter: listAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = this
        recyclerView = findViewById(R.id.rv_main)
        viewModel = ViewModelProviders.of(context!!)[MainViewModel::class.java]
        viewModel!!.getUserMutableLiveData()!!.observe(context!!, userListUpdateObserver)
    }

    var userListUpdateObserver: Observer<List<dataModel>> =
        Observer<List<dataModel>> { dataModels ->
            recyclerViewAdapter = listAdapter()
            recyclerViewAdapter!!.listAdapter(dataModels)
            recyclerView!!.layoutManager = LinearLayoutManager(context)
            recyclerView!!.adapter = recyclerViewAdapter
        }
}
