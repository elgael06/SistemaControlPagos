package com.example.sistemacontrolpagos

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import com.example.sistemacontrolpagos.Manejadores.Usuario_manager
import com.example.sistemacontrolpagos.Modelos.Usuario
import com.example.sistemacontrolpagos.Vistas.EdicionCliente
import com.example.sistemacontrolpagos.Vistas.Moviminetos_cuentas
import com.example.sistemacontrolpagos.Vistas.Saldo_cliente
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

    fun llenarUsuarios(){

        var lista = Usuario_manager().Todos(this)

        lista.map {
            usuario ->{agregar_usuario_a_lista(usuario)}
        }
    }
    fun agregar_usuario_a_lista(valor:Usuario){
        var fila = TableRow(applicationContext)
        var id = TextView(applicationContext)
        var nombre = TextView(applicationContext)

        id.setText(valor.codigo)
        nombre.setText(valor.nombre)

        fila.addView(id)
        fila.addView(nombre)


        tabla_usuarios.addView(fila, TableLayout.LayoutParams(
            TableLayout.LayoutParams.WRAP_CONTENT,
            TableLayout.LayoutParams.MATCH_PARENT))
    }
}
