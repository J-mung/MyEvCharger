package com.example.myevcharger.data.local.datasource

import androidx.lifecycle.LiveData
import com.example.myevcharger.domain.model.EvCharger

interface LocalEvChargerDataSource {
    suspend fun upsert(evCharger: EvCharger): Long

    fun getSavedEvCharger(): LiveData<List<EvCharger>>

}