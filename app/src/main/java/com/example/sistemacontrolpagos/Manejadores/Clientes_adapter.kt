package com.example.sistemacontrolpagos.Manejadores

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sistemacontrolpagos.Modelos.Usuario
import com.example.sistemacontrolpagos.R
import kotlinx.android.synthetic.main.view_cliente.view.*

class Clientes_adapter(val lista :ArrayList<Usuario>) : RecyclerView.Adapter<Clientes_adapter.vista_cliente>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): vista_cliente {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.view_cliente, parent, false)
        return vista_cliente(v)
    }
    override fun getItemCount(): Int=lista.size
    override fun onBindViewHolder(holder: vista_cliente, position: Int) {
        holder.crear_item(lista[position])
    }
    class vista_cliente (itemView:View): RecyclerView.ViewHolder(itemView){
       fun crear_item(item:Usuario){
           itemView.txt_nombre.text = item.nombre
        }
    }
}