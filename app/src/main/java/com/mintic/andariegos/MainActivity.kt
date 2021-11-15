package com.mintic.andariegos

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var boton = findViewById<Button>(R.id.ingreso)
        boton.setOnClickListener {
           var intent = Intent(this,chingaza::class.java)
           startActivity(intent)
        }

    }
}