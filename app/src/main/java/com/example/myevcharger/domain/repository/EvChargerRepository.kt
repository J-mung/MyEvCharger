package com.example.myevcharger.domain.repository

import androidx.lifecycle.LiveData
import com.example.myevcharger.data.remote.model.EvChargerResponse
import com.example.myevcharger.domain.model.EvCharger
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface EvChargerRepository {

    suspend fun getAllCharger() : Response<EvChargerResponse>

    fun getSavedEvCharger() : LiveData<List<EvCharger>>

    fun upsert(evCharger: EvCharger) : Long

    suspend fun isSavedCharger(statId: Int): Boolean

    suspend fun deleteCharger(statId: Int)
}