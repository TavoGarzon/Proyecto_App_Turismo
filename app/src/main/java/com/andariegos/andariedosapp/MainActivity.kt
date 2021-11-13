package com.andariegos.andariedosapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_Cocora)

        val back_button: Button = findViewById(R.id.send_button)

        sendButton.setOnClickListener{ it:View!
            log.d(tag:"MainActivity", msg: "Send Button clicked")
        }
    }
}