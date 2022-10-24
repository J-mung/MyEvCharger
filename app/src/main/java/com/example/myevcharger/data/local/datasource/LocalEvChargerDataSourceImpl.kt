package com.example.myevcharger.data.local.datasource

import androidx.lifecycle.LiveData
import com.example.myevcharger.data.local.dao.EvChargerDao
import com.example.myevcharger.domain.model.EvCharger
import javax.inject.Inject

class LocalEvChargerDataSourceImpl @Inject constructor(
    private val evChargerDao: EvChargerDao,
): LocalEvChargerDataSource {
    override fun getSavedEvCharger(): LiveData<List<EvCharger>> =
        evChargerDao.getSavedEvCharger()

    override fun upsert(evCharger: EvCharger): Long =
        evChargerDao.upsert(evCharger)

    override suspend fun isSavedCharger(statId: Int): Boolean =
        evChargerDao.isSavedCharger(statId)

    override suspend fun deleteCharger(statId: Int) =
        evChargerDao.deleteCharger(statId)

    companion object {
        private const val TAG = "LocalEvChargerDataSourceImpl"
    }
}