package com.example.signinsignup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignIn : AppCompatActivity() {

    lateinit var etSavedPw : EditText
    lateinit var etSavedNum : EditText
    lateinit var button : Button

    lateinit var dbH : DataBaseHandler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        etSavedPw = findViewById(R.id.etSavedPw)
        etSavedNum = findViewById(R.id.etSavedNum)
        button = findViewById(R.id.button)

        dbH = DataBaseHandler(this)

        button.setOnClickListener {
            val num = etSavedNum.text.toString()
            val password = etSavedPw.text.toString()

          val pw =  dbH.checkpassword(password)

            if(pw.equals(password)){
                val intent = Intent(applicationContext, Details::class.java)
                intent.putExtra("Number", num)
                startActivity(intent)
            }
            else{
                Toast.makeText(applicationContext, "Invaild details", Toast.LENGTH_SHORT).show()
            }

        }
    }
}