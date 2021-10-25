package com.example.samplemvvmkotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.samplemvvmkotlin.R
import com.example.samplemvvmkotlin.model.dataModel

class listAdapter: RecyclerView.Adapter<listAdapter.ViewHolder>() {
    private var dataModels: List<dataModel>? = null

    fun listAdapter(dataModels: List<dataModel>?) {
        this.dataModels = dataModels
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.itemcustom, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataModel = dataModels!![position]
        holder.texta.text = "" + dataModel.getId()
        holder.textb.text = "" + dataModel.getName()
        holder.textc.text = "" + dataModel.getTitle()
        holder.textd.text = "" + dataModel.getSubTitle()
    }

    override fun getItemCount(): Int {
        return dataModels!!.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var texta: TextView
        var textb: TextView
        var textc: TextView
        var textd: TextView

        init {
            texta = itemView.findViewById(R.id.texta)
            textb = itemView.findViewById(R.id.textb)
            textc = itemView.findViewById(R.id.textc)
            textd = itemView.findViewById(R.id.textd)
        }
    }
}