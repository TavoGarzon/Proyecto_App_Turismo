package com.mintic.andariegos.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SitioItem(
    @SerializedName("caracteristicas")
    val caracteristicas: String,
    @SerializedName("descripcion")
    val descripcion: String,
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("puntuacion")
    val puntuacion: String,
    @SerializedName("urlfoto")
    val urlfoto: String
):Serializable