package com.mintic.andariegos.Retrofit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mintic.andariegos.model.SitioItem
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private var sitesList = MutableLiveData<List<SitioItem>>()

    private var factory = RetrofitFactory.apiService()

    init {
       // requestUsers()
       requestUsersFromService()
    }

   fun getSites() :LiveData<List<SitioItem>> = sitesList

    private fun requestUsers(){
        var list = listOf<SitioItem>(
            SitioItem("parque","chingaza","malo","","",""),
            SitioItem("parque","cocora","bueno","","",""),
            SitioItem("parque","santurban","regular","","",""),
            SitioItem("parque","cocora","excelente","","","")
        )
        sitesList.value = list
    }


    fun requestUsersFromService() {

            viewModelScope.launch {
            sitesList.postValue(factory.reqSites())

        }

   }
}