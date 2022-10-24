package com.example.myevcharger.data.local.datasource

import com.example.myevcharger.data.local.database.EvChargerDatabase
import com.example.myevcharger.domain.model.EvCharger
import javax.inject.Inject

class LocalEvChargerDataSourceImpl @Inject constructor(
    val db: EvChargerDatabase,
): LocalEvChargerDataSource {
    override suspend fun upsert(evCharger: EvCharger) = db.getEvChargerDao().upsert(evCharger)

    override fun getSavedEvCharger() = db.getEvChargerDao().getAllCharger()

}