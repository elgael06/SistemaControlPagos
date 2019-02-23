package com.example.sistemacontrolpagos

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Layout
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import com.example.sistemacontrolpagos.Manejadores.Clientes_adapter
import com.example.sistemacontrolpagos.Manejadores.Usuario_manager
import com.example.sistemacontrolpagos.Manejadores.myAdapter
import com.example.sistemacontrolpagos.Modelos.Usuario
import com.example.sistemacontrolpagos.Vistas.EdicionCliente
import com.example.sistemacontrolpagos.Vistas.Moviminetos_cuentas
import com.example.sistemacontrolpagos.Vistas.Saldo_cliente
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_cliente.view.*

//import org.jetbrains.anko.find

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val recicle:RecyclerView = find(R.id.Contenedor_clientes)

        llenarUsuarios()
        actualizar.setOnClickListener{
            llenarUsuarios()
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menus_acciones_clientes,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        var id:Int = item?.itemId ?: 0
        when(id){
            R.id.menu_nuevo->{Ir_a_edicion(0)
            }
            R.id.menu_editar->{Ir_a_edicion(1)
            }
            R.id.menu_saldos->{Ir_a_saldos()
            }
            R.id.menu_moviminetos->{Ir_a_moviminetos()
            }
            R.id.menu_cerrar->{finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
    fun Ir_a_edicion(usuario:Int?){
        Toast.makeText(applicationContext,"Edicion", Toast.LENGTH_SHORT).show()
        var vista: Intent = Intent(this, EdicionCliente() ::class.java)
        startActivity(vista)
    }
    fun Ir_a_saldos(){
        Toast.makeText(applicationContext,"Saldos", Toast.LENGTH_SHORT).show()
        var vista: Intent = Intent(this, Saldo_cliente() ::class.java)
        startActivity(vista)
    }
    fun Ir_a_moviminetos(){
        Toast.makeText(applicationContext,"Moviminetos", Toast.LENGTH_SHORT).show()
        var vista: Intent = Intent(this, Moviminetos_cuentas() ::class.java)
        startActivity(vista)
    }

    fun llenarUsuarios( ){
        val lista_ = Usuario_manager().Todos(this)

        tabla_usuarios.removeAllViewsInLayout()
        tabla_usuarios.clearDisappearingChildren()
        lista_?.forEach {agregar_usuario_a_lista(it)}

        Lista_clientes.layoutManager = LinearLayoutManager(this)
        Lista_clientes.hasFixedSize()
        Lista_clientes.adapter = Clientes_adapter(lista_)

        Lista_clientes.layoutManager = LinearLayoutManager(this)
        Lista_clientes.adapter = Clientes_adapter(lista_)

   //
    }
    fun agregar_usuario_a_lista(valor:Usuario){
        var fila = TableRow(applicationContext)
        var nombre = TextView(applicationContext)

        nombre.text = valor.nombre

        fila.addView(nombre)

        tabla_usuarios.addView(fila, TableLayout.LayoutParams(
            TableLayout.LayoutParams.WRAP_CONTENT,
            TableLayout.LayoutParams.MATCH_PARENT))
    }
}
