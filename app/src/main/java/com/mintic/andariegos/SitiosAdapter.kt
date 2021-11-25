package com.mintic.andariegos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.util.ArrayList


class SitiosAdapter(
    private val mSitios: ArrayList<Sitios>,
    private val context: Context,
    private val onClick: (Sitios) -> Unit
) : RecyclerView.Adapter<SitiosAdapter.ContactViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sites_list_item, parent, false)
        return ContactViewHolder(view)
    }

    override fun onBindViewHolder(holderContact: ContactViewHolder, position: Int) {
        val contact = mSitios[position]
        holderContact.bind(sitios = contact)
    }

    override fun getItemCount(): Int {
        return mSitios.size
    }

    inner class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var nameLabel: TextView = itemView.findViewById(R.id.textview_name)
        private var emailLabel: TextView = itemView.findViewById(R.id.textview_descrip)
        private var imageView: ImageView = itemView.findViewById(R.id.imageview_thumb)
        private var currentSitios: Sitios? = null

        init {
            itemView.setOnClickListener {
                currentSitios?.let {
                    onClick(it)
                }
            }
        }

        /* Bind Contact name and image. */
        fun bind(sitios: Sitios) {
            currentSitios = sitios

            val fullName = "${sitios.nombre} ${sitios.ubicacion}"
            nameLabel.text = fullName
            emailLabel.text = sitios.descripcion

            Glide.with(context)
                .load(sitios.imageUrl)
                .into(imageView)
        }
    }
}
