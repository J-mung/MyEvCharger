package com.example.myevcharger.domain.repository.local

import androidx.lifecycle.LiveData
import com.example.myevcharger.domain.model.EvCharger

interface LocalEvChargerRepository {
    suspend fun getAllCharger(): LiveData<List<EvCharger>>

    suspend fun getChargerZcode(zcode: Int): LiveData<List<EvCharger>>

}