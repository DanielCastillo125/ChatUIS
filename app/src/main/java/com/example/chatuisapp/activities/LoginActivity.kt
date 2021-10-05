package com.example.chatuisapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chatuisapp.R
import kotlinx.android.synthetic.main.activity_login.*
import android.content.Intent
import android.widget.Toast
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class LoginActivity : AppCompatActivity() {

    private val auth =Firebase.auth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        ingresar.setOnClickListener { loginUser() }
        registrar.setOnClickListener { createUser() }

        checkUser()
    }

    private fun checkUser(){
        val currentUser = auth.currentUser

        if(currentUser != null){
            val intent = Intent(this,ListOfChatsActivity::class.java)
            intent.putExtra( "user",currentUser.email)
            startActivity(intent)

            finish()
        }
    }

    private fun createUser(){

    }

    private fun loginUser(){
        val email =usuario.text.toString()
        val password =contraseña.text.toString()
        auth.signInWithEmailAndPassword(email , password ).addOnCompleteListener { task ->
            if (task.isSuccessful){
                checkUser()
            }else{
                task.exception?.let{
                    Toast.makeText(baseContext,it.message,Toast.LENGTH_LONG).show()
                }
            }
        }
    }

}