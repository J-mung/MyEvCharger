package com.example.myevcharger.data.local.repository

import com.example.myevcharger.data.api.RetrofitInstance
import com.example.myevcharger.data.database.EvChargerDatabase
import com.example.myevcharger.domain.model.EvCharger
import kotlinx.coroutines.flow.Flow

class LocalEvChargerRepositoryImpl (
    val db: EvChargerDatabase
) {
    suspend fun getAllCharger() =
        RetrofitInstance.api.getEvChargers()

    //suspend fun getChargerZcode(zcode: Int) = RetrofitInstance.api.getEvChargers(zcode)

    suspend fun insert(evCharger: EvCharger) = db.getEvChargerDao().upsert(evCharger)

    fun getSavedEvCharger() = db.getEvChargerDao().getAllCharger()

}