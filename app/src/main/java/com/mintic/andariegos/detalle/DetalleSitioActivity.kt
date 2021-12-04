package com.mintic.andariegos.detalle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mintic.andariegos.databinding.ActivityDetalleSitioBinding
import com.mintic.andariegos.model.SitioItem
import com.squareup.picasso.Picasso

class DetalleSitioActivity : AppCompatActivity() {

    private lateinit var detalleSitioBinding: ActivityDetalleSitioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detalleSitioBinding = ActivityDetalleSitioBinding.inflate(layoutInflater)
        setContentView(detalleSitioBinding.root)

        val sitio: SitioItem = intent.extras?.getSerializable("sitio") as SitioItem
        with(detalleSitioBinding) {
            nombreTextView.text = sitio.nombre
            descripcionTextView.text = sitio.descripcion
            puntuacionTextView.text = sitio.puntuacion
            Picasso.get().load(sitio.urlfoto).into(fotoImageView)
        }
    }

}



