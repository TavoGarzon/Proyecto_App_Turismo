package com.mintic.andariegos.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SitioItem(
    @SerializedName("descripcion")
    val descripcion: String,
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("puntuacion")
    val puntuacion: String,
    @SerializedName("urlfoto")
    val urlfoto: String,
    @SerializedName("lat")
    val lat: String,
    @SerializedName("long")
    val long: String
):Serializable