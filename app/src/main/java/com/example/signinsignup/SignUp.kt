package com.example.signinsignup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUp : AppCompatActivity() {

    lateinit var etName : EditText
    lateinit var etNumber : EditText
    lateinit var etLocation : EditText
    lateinit var etPassword : EditText
    lateinit var btSubmit : Button
    lateinit var dbH : DataBaseHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        etName = findViewById(R.id.etName)
        etNumber = findViewById(R.id.etNumber)
        etLocation = findViewById(R.id.etLocation)
        etPassword = findViewById(R.id.etPassword)
        btSubmit = findViewById(R.id.btSubmit)
        dbH = DataBaseHandler(this)

    }

    fun openDetails(view: android.view.View) {
        val nameS = etName.text.toString()
        val locationS = etLocation.text.toString()
        val numberS = etNumber.text.toString()
        val passwordS = etPassword.text.toString()

       val status =  dbH.savedet(nameS,locationS,numberS,passwordS)

        Toast.makeText(applicationContext, "data saved successfully! ${status} ", Toast.LENGTH_SHORT)
            .show()
        if(status.equals("-1")){

            Toast.makeText(applicationContext, "Error data not saved!", Toast.LENGTH_SHORT)
                .show()
        }
        else{

        val intent = Intent(applicationContext, Details::class.java)
        intent.putExtra("Name", nameS)
        intent.putExtra("Number", numberS)
        intent.putExtra("Location",locationS )
        intent.putExtra("Password", passwordS)
        startActivity(intent)

    }
}}