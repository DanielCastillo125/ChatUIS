package com.example.chatuisapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var textUsuario: EditText
    lateinit var textContraseña: EditText
    lateinit var btn_ingresar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textUsuario = findViewById(R.id.usuario)
        textContraseña = findViewById(R.id.contraseña)
        btn_ingresar = findViewById(R.id.boton)
        btn_ingresar.setOnClickListener{
            Toast.makeText(this, "IsaacPete", Toast.LENGTH_SHORT).show()
        }
    }

}