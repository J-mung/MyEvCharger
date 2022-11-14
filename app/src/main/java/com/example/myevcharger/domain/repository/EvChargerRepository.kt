package com.example.myevcharger.domain.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.example.myevcharger.data.remote.model.EvChargerApiModel
import com.example.myevcharger.data.remote.model.EvChargerResponse
import com.example.myevcharger.domain.model.EvCharger
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface EvChargerRepository {

    // remote data source
    suspend fun getAllCharger() : Flow<PagingData<EvCharger>>
    //suspend fun getAllCharger() : EvChargerResponse

    // local data source
    fun getSavedEvCharger() : LiveData<List<EvCharger>>

    suspend fun upsert(evCharger: EvCharger) : Long

    suspend fun isSavedCharger(statId: Int): Boolean

    suspend fun deleteCharger(statId: Int)
}