package com.mintic.andariegos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SitiosAdapter(
    private val poiList: ArrayList<SitioItem>) :
    RecyclerView.Adapter<SitiosAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_poi, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sitio = poiList[position]
        holder.bind(sitio)
    }

    override fun getItemCount(): Int = poiList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private var nombreTextView: TextView = itemView.findViewById(R.id.nombre_text_view)
        private var descripcionTextView: TextView = itemView.findViewById(R.id.descripcion_text_view)
        private var caracteristicasTextView: TextView = itemView.findViewById(R.id.caracteristicas_text_view)
        private var puntuacionTextView: TextView = itemView.findViewById(R.id.puntuacion_text_view)
        private var fotoImageView: ImageView = itemView.findViewById(R.id.foto_image_view)

        fun bind(sitio: SitioItem){
            nombreTextView.text = sitio.nombre
            descripcionTextView.text = sitio.descripcion
            caracteristicasTextView.text = sitio.caracteristicas
            puntuacionTextView.text = sitio.puntuacion
            //picture
        }
    }
}