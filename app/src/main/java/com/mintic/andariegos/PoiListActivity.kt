package com.mintic.andariegos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PoiListActivity : AppCompatActivity() {

    private lateinit var listSitios: ArrayList<Sitio>
    private lateinit var sitiosAdapter: SitiosAdapter
    private lateinit var poiRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_poi_list)

        poiRecyclerView = findViewById(R.id.poi_recycler_view)

        listSitios = createMockSitios()

        sitiosAdapter = SitiosAdapter(listSitios)

        /*poiRecyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))*/

        poiRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = sitiosAdapter
            setHasFixedSize(false)
        }
        /*poiRecyclerView.adapter = sitiosAdapter*/
    }

    private fun createMockSitios(): ArrayList<Sitio> {
        /*var lista: ArrayList<Sitio> = arrayListOf()
        var sitio = Sitio(nombre = "Paramo de Santurbán",
                descripcion = "El Páramo de Santurbán se ubica en los departamentos de Santander y Norte de Santander en una altura desde los 2.800 y hasta los 4.290 metros sobre el nivel del mar." +
                        "El Páramo de Santurbán es hábitat de 457 especies de plantas, 17 de anfibios, 17 de reptiles, 201 de aves y 58 de mamíferos." +
                        "Si te gusta la fotografía encontrarás paisajes dignos de postales y si disfrutas el ecoturismo estar rodeado de tanta naturaleza mientras el frío rosa tu piel te dejará fascinado.",
                caracteristicas = "Temperatura: 0°c hasta 32°c" + "Sitios recomendados: Los mayores atractivos de turismo en el Páramo Santurbán son sus Lagunas.",
                puntuacion = "8.7/10"
                )
        lista.add(sitio)
        return list*/

        return arrayListOf(
                Sitio(
                        nombre = "Paramo de Santurbán",
                        descripcion = "El Páramo de Santurbán se ubica en los departamentos de Santander y Norte de Santander en una altura desde los 2.800 y hasta los 4.290 metros sobre el nivel del mar. " +
                                "Es hábitat de 457 especies de plantas, 17 de anfibios, 17 de reptiles, 201 de aves y 58 de mamíferos. " +
                                "Los mayores atractivos de turismo en el Páramo Santurbán son sus Lagunas.",
                        caracteristicas = "Temperatura: 0°c hasta 32°c. ",
                        puntuacion = "Puntuación: 8.7/10")
        )
    }
}