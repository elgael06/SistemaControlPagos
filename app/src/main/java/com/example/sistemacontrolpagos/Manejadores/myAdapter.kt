package com.example.sistemacontrolpagos.Manejadores

import android.widget.TextView
import android.view.ViewGroup
import android.support.v7.widget.RecyclerView

class myAdapter(val item :List<String>):RecyclerView.Adapter<myAdapter.viewHolder>(){
    class viewHolder(val textView: TextView):RecyclerView.ViewHolder(textView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        return viewHolder(TextView(parent.context))
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.textView.text = item[position]
    }
    override fun getItemCount(): Int = item.size

}