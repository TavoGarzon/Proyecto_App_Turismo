package com.mintic.andariegos.Retrofit

import com.mintic.andariegos.model.SitioItem
import retrofit2.http.GET

interface ApiService {
    @GET("/TavoGarzon/dbAndariegos")
    suspend fun  requestSites() : List<SitioItem>
}