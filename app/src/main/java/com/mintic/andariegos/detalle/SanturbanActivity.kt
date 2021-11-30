package com.mintic.andariegos.detalle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mintic.andariegos.databinding.ActivitySanturbanBinding
import com.mintic.andariegos.model.SitioItem
import com.squareup.picasso.Picasso
import java.io.Serializable

class SanturbanActivity : AppCompatActivity() {

    private lateinit var santurbanBinding: ActivitySanturbanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        santurbanBinding = ActivitySanturbanBinding.inflate(layoutInflater)
        setContentView(santurbanBinding.root)

        val sitio: SitioItem = intent.extras?.getSerializable("sitio") as SitioItem
        with(santurbanBinding) {
            nombreTextView.text = sitio.nombre
            descripcionTextView.text = sitio.descripcion
            caracteristicasTextView.text = sitio.caracteristicas
            puntuacionTextView.text = sitio.puntuacion
            Picasso.get().load(sitio.urlfoto).into(fotoImageView)
        }
    }

}



