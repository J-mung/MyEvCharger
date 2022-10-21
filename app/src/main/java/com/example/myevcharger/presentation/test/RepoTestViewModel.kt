package com.example.myevcharger.presentation.test

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myevcharger.data.local.repository.LocalEvChargerRepositoryImpl
import com.example.myevcharger.domain.model.EvChargerResponse
import com.example.myevcharger.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class RepoTestViewModel(
    val chargerRepository: LocalEvChargerRepositoryImpl
) : ViewModel() {

    val chargers: MutableLiveData<Resource<EvChargerResponse>> = MutableLiveData()
    var chargerPage = 1
    var chargerResponse: EvChargerResponse? = null

    init {
        getChargers()
    }

    fun getChargers() = viewModelScope.launch {
        chargers.postValue(Resource.Loading())
        val response = chargerRepository.getAllCharger()
        chargers.postValue(handleChargersResponse(response))
    }

    fun handleChargersResponse(response: Response<EvChargerResponse>): Resource<EvChargerResponse> {
        if(response.isSuccessful) {
            response.body()?.let { resultResponse ->
                chargerPage++
                if (chargerResponse == null) {
                    chargerResponse = resultResponse
                } else {
                    val newChargers = resultResponse.evChargers
                    chargerResponse?.evChargers?.addAll(newChargers)
                }
                return Resource.Success(chargerResponse ?: resultResponse)
            }
        }
        return Resource.Error(response.message())
    }
}