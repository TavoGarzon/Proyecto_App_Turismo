package com.mintic.andariegos.list

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.mintic.andariegos.R
import com.mintic.andariegos.SettingsFragment
import com.mintic.andariegos.detalle.DetalleSitioActivity
import com.mintic.andariegos.model.Sitio
import com.mintic.andariegos.model.SitioItem

class PoiListActivity : AppCompatActivity() {

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.overflow_menu, menu)
        return true
    }

    /*TODO() ARREGLAR ESTA FUNCION
       override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val fm : FragmentManager = supportFragmentManager
        val ft : FragmentTransaction = fm.beginTransaction()

          return when (item.itemId) {
             R.id.menu_ajustes -> {
                 val settingsFragment = SettingsFragment()
                 ft.replace(R.id.fragment_container_view_tag, settingsFragment).commit()
                 ft.addToBackStack(null)
                 true
             }
             else -> {
                 return true
             }
         }
    }*/

    private lateinit var listSitios: ArrayList<SitioItem>
    private lateinit var sitiosAdapter: SitiosAdapter
    private lateinit var poiRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_poi_list)

        poiRecyclerView = findViewById(R.id.poi_recycler_view)

        //listSitios = createMockSitios() "Crear una lista de sitios desde un Array"

        listSitios = loadMockSitiosJson()
        sitiosAdapter = SitiosAdapter(listSitios, onItemClicked = { onSitioClicked(it) })

        poiRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = sitiosAdapter
            setHasFixedSize(false)
        }

    }

    private fun onSitioClicked(sitio: SitioItem) {
        val intent = Intent(this, DetalleSitioActivity::class.java)
        intent.putExtra("sitio", sitio)
        startActivity(intent)
    }

    private fun loadMockSitiosJson(): ArrayList<SitioItem> {
        val sitiosString: String =
            applicationContext.assets.open("sitios.json").bufferedReader().use { it.readText() }
        val gson = Gson()
        val sitioList = gson.fromJson(sitiosString, Sitio::class.java)
        return sitioList
    }


    /* private fun createMockSitios(): ArrayList<Sitio> {

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
    }*/
}