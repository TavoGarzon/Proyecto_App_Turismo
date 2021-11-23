package com.mintic.andariegos

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class chingaza : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chingaza)

        var boton = findViewById<Button>(R.id.retornar)
        boton.setOnClickListener {
            var intent = Intent(this,sitios::class.java)
            startActivity(intent)
        }

    }
}