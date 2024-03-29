package com.example.sistemacontrolpagos.Manejadores

import android.content.ContentValues
import android.content.Context
import android.widget.Toast
import com.example.sistemacontrolpagos.Data.tabla_usuarios
import com.example.sistemacontrolpagos.Modelos.Usuario

class Usuario_manager {
    fun AltaUsuario(seleccion: Usuario,contexto: Context){
        var user=  tabla_usuarios(contexto,"Administracion", null, 1)
        var  bd = user.writableDatabase

        val registro = ContentValues()

//        registro.put("codigo",seleccion.codigo)
        registro.put("nombre",seleccion.nombre)
        registro.put("referencia",seleccion.referencia)
        registro.put("direccion",seleccion.direccion)
        registro.put("estatus",seleccion.estatus)
        registro.put("numero_telefono",seleccion.numero_telefono)

        bd.insert("Usuarios",null,registro )

        bd.close()
        Toast.makeText(contexto, "Se cargaron los datos del Usuario.", Toast.LENGTH_SHORT).show()
    }
    fun BajaUsuario(codigo:Int,contexto: Context){
        var user=  tabla_usuarios(contexto,"Administracion", null, 1)
        var  bd = user.writableDatabase
        val cant = bd.delete("articulos", "codigo=${codigo}", null)

        bd.close()
        when(cant){
            1->Toast.makeText(contexto, "Se Borraron los datos del Usuario.", Toast.LENGTH_SHORT).show()
            else ->Toast.makeText(contexto, "Error al Borrar Los Datos del Usuario.", Toast.LENGTH_SHORT).show()
        }
    }
    fun BuscarPorCodigo(codigo:Int,contexto: Context):Usuario{
        var usuario = Usuario()
        var user=  tabla_usuarios(contexto,"Administracion", null, 1)
        var  bd = user.writableDatabase
        val fila = bd.rawQuery("select * from Usuarios where codigo='${codigo}'", null)

        if (fila.moveToFirst()){
            usuario.codigo=   fila.getString(0).toInt()
            usuario.nombre=   fila.getString(1)
            usuario.referencia =   fila.getString(2)
            usuario.direccion =   fila.getString(3)
            usuario.numero_telefono=   fila.getString(4)
            usuario.estatus=   fila.getString(5)

        }else Toast.makeText(contexto, "Error No existe los datos del Usuario.", Toast.LENGTH_SHORT).show()

        bd.close()
        return  usuario
    }
    fun Todos(contexto: Context):ArrayList<Usuario>{
       var usuarios:ArrayList<Usuario> = ArrayList()

        var user=  tabla_usuarios(contexto,"Administracion", null, 1)
        var  bd = user.writableDatabase
        val fila = bd.rawQuery("select * from Usuarios ", null)

        while( fila.moveToNext()){

                var usuario = Usuario()

                usuario.codigo          = fila.getInt(0)
                usuario.nombre          = fila.getString(1)
                usuario.referencia      = fila.getString(2)
                usuario.direccion       = fila.getString(3)
                usuario.numero_telefono = fila.getString(4)
                usuario.estatus         = fila.getString(5)

                usuarios.add(usuario)
        }

        bd.close()

        Toast.makeText(contexto, "Usuarios:${usuarios.count()}", Toast.LENGTH_SHORT).show()
        return  usuarios
    }
    fun CambioUsuario(seleccion: Usuario,contexto: Context){
        var user=  tabla_usuarios(contexto,"Administracion", null, 1)
        var  bd = user.writableDatabase

        val registro = ContentValues()

        registro.put("codigo",seleccion.codigo)
        registro.put("nombre",seleccion.nombre)
        registro.put("referencia",seleccion.referencia)
        registro.put("direccion",seleccion.direccion)
        registro.put("estatus",seleccion.estatus)
        registro.put("numero_telefono",seleccion.numero_telefono)

        bd.update("Usuarios",registro,"codigo=${seleccion.codigo}",null )
        bd.close()
        Toast.makeText(contexto, "Se Actualizaron los datos del Usuario.", Toast.LENGTH_SHORT).show()
    }
}