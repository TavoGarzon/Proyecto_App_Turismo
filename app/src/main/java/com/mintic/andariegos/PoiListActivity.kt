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
                        puntuacion = "Puntuación: 8.7/10"),
                Sitio(
                        nombre = "Laguna del Otún",
                        descripcion = "Es un embalse natural que se encuentra en el departamento de Risaralda, en el área perteneciente al Parque Nacional Natural Los Nevados. ",
                        caracteristicas = "Está formada por la acción volcánica y glaciar alimentada principalmente por el deshielo del Nevado de Santa Isabel.\n" +
                                "Temperatura promedio: 10°C\n",
                        puntuacion = "Puntuación: 8.4/10"),
                Sitio(
                        nombre = "Cocora",
                        descripcion = "En la reserva natural Valle del Cocora se encuentra el hogar del árbol nacional de Colombia, la Palma de Cera del Quindío. una especie nativa del bosque andino colombiano. "+
                                "Se encuentra dentro de los límites de Parque Nacional de los Nevados, uno de los Parques más importantes de la región, pues es el nacimiento de decenas de ríos que surten de agua la región central del país. ",
                        caracteristicas = "Su temperatura oscila entre los 5ºC y 16ºC.",
                        puntuacion = "Puntuación: 8.5/10")
        )
    }
}