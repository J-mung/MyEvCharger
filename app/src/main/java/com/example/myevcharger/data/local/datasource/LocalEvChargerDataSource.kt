package com.example.myevcharger.data.local.datasource

import androidx.lifecycle.LiveData
import com.example.myevcharger.domain.model.EvCharger

interface LocalEvChargerDataSource {
    fun getSavedEvCharger(): LiveData<List<EvCharger>>

    fun upsert(evCharger: EvCharger): Long

    suspend fun isSavedCharger(statId: Int): Boolean

    suspend fun deleteCharger(statId: Int)
}