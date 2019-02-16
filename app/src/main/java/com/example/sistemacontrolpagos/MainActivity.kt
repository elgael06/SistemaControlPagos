package com.example.sistemacontrolpagos

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sistemacontrolpagos.Vistas.EdicionCliente
import com.example.sistemacontrolpagos.Vistas.Moviminetos_cuentas
import com.example.sistemacontrolpagos.Vistas.Saldo_cliente
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Ir_edicion.setOnClickListener{
            Ir_a_edicion()
        }
        Ir_moviminetos.setOnClickListener{
            Ir_a_moviminetos()
        }
        Ir_saldos.setOnClickListener{
            Ir_a_saldos()
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
}
