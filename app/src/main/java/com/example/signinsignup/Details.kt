package com.example.signinsignup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Details : AppCompatActivity() {

    lateinit var tvWelcome : TextView
    lateinit var tvDetails : TextView
    lateinit var dbhr: DataBaseHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        tvWelcome = findViewById(R.id.tvWelcome)
        tvDetails = findViewById(R.id.tvDetails)
        dbhr = DataBaseHandler(applicationContext)


        val number =  intent.getStringExtra("Number")



       val d = dbhr.getdet(number)

        tvDetails.setText("Your details are \n"+d+"\n")

    }
}