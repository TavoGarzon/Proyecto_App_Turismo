package com.mintic.andariegos.Retrofit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mintic.andariegos.model.SitioItem
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private var sitesList = MutableLiveData<List<SitioItem>>()

    init {
       // requestUsers()
       //requestUsersFromService()
    }

   /* fun getSites() :LiveData<List<SitioItem>> = sitesList
    private fun requestUsers(){
        var list = listOf<SitioItem>(
            SitioItem("parque","chingaza","PG",""),
            SitioItem("parque","cocora","PM",""),
            SitioItem("parque","santurban","JA",""),
            SitioItem("parque","cocora","CR","")
        )
        sitesList.value = list
    }*/

   /* private fun requestUsersFromService() {
        viewModelScope.launch {
            sitesList.value = ApiService.requestSites()

        }
    }*/
}