package com.example.signinsignup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openSignIn(view: android.view.View) {
        val intent = Intent(applicationContext, SignIn::class.java)
        startActivity(intent)
    }
    fun openSignUp(view: android.view.View) {
        val intent = Intent(applicationContext, SignUp::class.java)
        startActivity(intent)
    }
}