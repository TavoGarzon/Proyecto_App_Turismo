package com.mintic.andariegos

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.mintic.andariegos.R.id.imageButton

class sitios : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sitios)
        var salir = findViewById<Button>(R.id.salir)
        salir.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)


            }

    }


}