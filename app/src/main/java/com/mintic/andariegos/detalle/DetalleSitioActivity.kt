package com.mintic.andariegos.detalle

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.mintic.andariegos.R
import com.mintic.andariegos.databinding.ActivityDetalleSitioBinding
import com.mintic.andariegos.model.SitioItem
import com.squareup.picasso.Picasso

class DetalleSitioActivity : AppCompatActivity() {

    private lateinit var detalleSitioBinding: ActivityDetalleSitioBinding
    /*var sitio: SitioItem = TODO()*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detalleSitioBinding = ActivityDetalleSitioBinding.inflate(layoutInflater)
        setContentView(detalleSitioBinding.root)

       /* val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            launchMap("","")
        }*/

        val sitio: SitioItem = intent.extras?.getSerializable("sitio") as SitioItem
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            launchMap(sitio.lat,sitio.long)
        }

        with(detalleSitioBinding) {
            nombreTextView.text = sitio.nombre
            descripcionTextView.text = sitio.descripcion
            puntuacionTextView.text = sitio.puntuacion
            ubicacionTextView.text = "Ubicado en las coordenadas: ${sitio.lat},${sitio.long}"
            Picasso.get().load(sitio.urlfoto).into(fotoImageView)
        }
    }

    private fun launchMap(lat: String,long: String ) {
        val geo = "geo:$lat,$long"
        val gmmIntentUri = Uri.parse(geo)
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        startActivity(mapIntent)

    }

}



