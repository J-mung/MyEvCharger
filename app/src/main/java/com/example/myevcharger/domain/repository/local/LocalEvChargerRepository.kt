package com.example.myevcharger.domain.repository.local

import com.example.myevcharger.domain.model.EvCharger
import kotlinx.coroutines.flow.Flow


interface LocalEvChargerRepository {
    suspend fun getAllCharger(): Flow<List<EvCharger>>

    suspend fun getChargerZcode(zcode: Int)

}