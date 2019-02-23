package com.example.sistemacontrolpagos

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import com.example.sistemacontrolpagos.Manejadores.Usuario_manager
import com.example.sistemacontrolpagos.Manejadores.myAdapter
import com.example.sistemacontrolpagos.Modelos.Usuario
import com.example.sistemacontrolpagos.Vistas.EdicionCliente
import com.example.sistemacontrolpagos.Vistas.Moviminetos_cuentas
import com.example.sistemacontrolpagos.Vistas.Saldo_cliente
import kotlinx.android.synthetic.main.activity_main.*
//import org.jetbrains.anko.find

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val recicle:RecyclerView = find(R.id.Contenedor_clientes)

        llenarUsuarios()

        Ir_edicion.setOnClickListener{
            Ir_a_edicion()
        }
        Ir_moviminetos.setOnClickListener{
            Ir_a_moviminetos()
        }
        Ir_saldos.setOnClickListener{
            Ir_a_saldos()
        }
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
            R.id.menu_nuevo->{
                Ir_a_edicion()
            }
            R.id.menu_editar->{
                Ir_a_saldos()
            }
            R.id.menu_saldos->{
                Ir_a_saldos()
            }
            R.id.menu_moviminetos->{
                Ir_a_moviminetos()
            }
            R.id.menu_cerrar->{
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
    fun Ir_a_edicion(){
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
        val lista:List<String> = listOf("uno","dos","tres")
        //recicle.layoutManager = LinearLayoutManager(this)
        //recicle.adapter = myAdapter(lista)

        tabla_usuarios.clearDisappearingChildren()
        lista_?.forEach {agregar_usuario_a_lista(it)}

   //
    }
    fun agregar_usuario_a_lista(valor:Usuario){
        var fila = TableRow(applicationContext)
        var id = TextView(applicationContext)
        var nombre = TextView(applicationContext)
        println("nombre=${nombre}")

        id.text = valor.codigo.toString()
        nombre.text = valor.nombre

        fila.addView(id)
        fila.addView(nombre)

        tabla_usuarios.addView(fila, TableLayout.LayoutParams(
            TableLayout.LayoutParams.WRAP_CONTENT,
            TableLayout.LayoutParams.MATCH_PARENT))
    }
}
