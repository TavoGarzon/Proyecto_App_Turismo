package com.mintic.andariegos

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         var botoom = findViewById<Button>(R.id.boton1)
        botoom.setOnClickListener {
          var  intent = Intent(this,sitios::class.java )
          startActivity(intent)
        }


       }



}