package com.example.sistemacontrolpagos.Vistas

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sistemacontrolpagos.Manejadores.Usuario_manager
import com.example.sistemacontrolpagos.R
import com.example.sistemacontrolpagos.Modelos.Usuario
import kotlinx.android.synthetic.main.activity_edicion_cliente.*

class EdicionCliente : AppCompatActivity() {

    var cliente = Usuario()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edicion_cliente)

        btn_estatus.textOff= "No"
        btn_estatus.textOn= "Si"

        btn_guardar.setOnClickListener{
            Guardar()
        }
    }
    fun Guardar(){

        if(comprobar_campos())
        {
            Usuario_manager().AltaUsuario(cliente,this)
            cliente = Usuario()
            txt_nombre.setText("")
            txt_direccion.setText("")
            txt_numero.setText("")
            txt_referencia.setText("")
            btn_estatus.text="No"
        }
        else Toast.makeText(applicationContext,"No Se Puede Guardar!!!", Toast.LENGTH_SHORT).show()
    }
    fun comprobar_campos():Boolean{
        asignar_usuario()
        print(cliente)
        return  ( cliente.nombre!="" && cliente.direccion!="" && cliente.numero_telefono!="" && cliente.referencia!="" )
    }
    private fun asignar_usuario(){
        cliente.nombre          =txt_nombre.text.toString()
        cliente.direccion       =txt_direccion.text.toString()
        cliente.numero_telefono =txt_numero.text.toString()
        cliente.referencia      = txt_referencia.text.toString()

            if(btn_estatus.text.toString() == "Si" )
                cliente.estatus         = "V"
            else cliente.estatus         =  "C"
    }
}
