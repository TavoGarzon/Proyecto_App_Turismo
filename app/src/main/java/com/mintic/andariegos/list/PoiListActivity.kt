package com.mintic.andariegos.list

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.mintic.andariegos.MainActivity
import com.mintic.andariegos.R
import com.mintic.andariegos.Retrofit.MainViewModel
import com.mintic.andariegos.SettingsFragment
import com.mintic.andariegos.detalle.DetalleSitioActivity
import com.mintic.andariegos.model.Sitio
import com.mintic.andariegos.model.SitioItem

class PoiListActivity : AppCompatActivity() {

    private lateinit var listSitios: List<SitioItem>
    private lateinit var sitiosAdapter: SitiosAdapter
    private lateinit var poiRecyclerView: RecyclerView
    private  lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_poi_list)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        poiRecyclerView = findViewById(R.id.poi_recycler_view)

        //listSitios = createMockSitios() "Crear una lista de sitios desde un Array"

        viewModel.getSites().observe(this, {
            listSitios = it
            sitiosAdapter = SitiosAdapter(listSitios, onItemClicked = { onSitioClicked(it) })
            poiRecyclerView.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = sitiosAdapter
                setHasFixedSize(false)
            }
        })


       /* poiRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = sitiosAdapter
            setHasFixedSize(false)
        }*/

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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.overflow_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.menu_ajustes  -> {
                val intent = Intent(this,
                    MainActivity::class.java)

                startActivity(intent)
            }
        }

        return super.onOptionsItemSelected(item)
    }

    /* private fun createMockSitios(): ArrayList<Sitio> {

        return arrayListOf(
                Sitio(
                        nombre = "Paramo de Santurb??n",
                        descripcion = "El P??ramo de Santurb??n se ubica en los departamentos de Santander y Norte de Santander en una altura desde los 2.800 y hasta los 4.290 metros sobre el nivel del mar. " +
                                "Es h??bitat de 457 especies de plantas, 17 de anfibios, 17 de reptiles, 201 de aves y 58 de mam??feros. " +
                                "Los mayores atractivos de turismo en el P??ramo Santurb??n son sus Lagunas.",
                        caracteristicas = "Temperatura: 0??c hasta 32??c. ",
                        puntuacion = "Puntuaci??n: 8.7/10"),
                Sitio(
                        nombre = "Laguna del Ot??n",
                        descripcion = "Es un embalse natural que se encuentra en el departamento de Risaralda, en el ??rea perteneciente al Parque Nacional Natural Los Nevados. ",
                        caracteristicas = "Est?? formada por la acci??n volc??nica y glaciar alimentada principalmente por el deshielo del Nevado de Santa Isabel.\n" +
                                "Temperatura promedio: 10??C\n",
                        puntuacion = "Puntuaci??n: 8.4/10"),
                Sitio(
                        nombre = "Cocora",
                        descripcion = "En la reserva natural Valle del Cocora se encuentra el hogar del ??rbol nacional de Colombia, la Palma de Cera del Quind??o. una especie nativa del bosque andino colombiano. "+
                                "Se encuentra dentro de los l??mites de Parque Nacional de los Nevados, uno de los Parques m??s importantes de la regi??n, pues es el nacimiento de decenas de r??os que surten de agua la regi??n central del pa??s. ",
                        caracteristicas = "Su temperatura oscila entre los 5??C y 16??C.",
                        puntuacion = "Puntuaci??n: 8.5/10")
        )
    }*/
}