package com.example.chatuisapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chatuisapp.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        ingresar.setOnClickListener { loginUser() }
        registrar.setOnClickListener { createUser() }

        checkUser()
    }

    private fun checkUser(){

    }

    private fun createUser(){

    }

    private fun loginUser(){

    }

}