package com.example.myevcharger.domain.repository

import androidx.lifecycle.LiveData
import com.example.myevcharger.data.remote.model.EvChargerResponse
import com.example.myevcharger.domain.model.EvCharger
import retrofit2.Response

interface EvChargerRepository {

    suspend fun getAllCharger() : Response<EvChargerResponse>

    suspend fun upsert(evCharger: EvCharger) : Long

    fun getSavedEvCharger() : LiveData<List<EvCharger>>
}