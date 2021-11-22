package com.mintic.andariegos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SitiosAdapter(
    private val poiList: ArrayList<Sitio>) :
    RecyclerView.Adapter<SitiosAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_poi_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sitio = poiList[position]
        holder.bind(sitio)
    }

    override fun getItemCount(): Int = poiList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private var nameTextView: TextView = itemView.findViewById(R.id.nombre_text_view)
        private var descripcionTextView: TextView = itemView.findViewById(R.id.descripcion_text_view)
        private var fotoImageView: ImageView = itemView.findViewById(R.id.foto_image_view)

        fun bind(sitio: Sitio){
            nameTextView.text = sitio.nombre
            nameTextView.text = sitio.descripcion
            //picture
        }
    }
}