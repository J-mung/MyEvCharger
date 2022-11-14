package com.example.myevcharger.data.repository

import android.nfc.tech.MifareUltralight.PAGE_SIZE
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.myevcharger.data.api.EvChargerApi
import com.example.myevcharger.data.local.datasource.LocalEvChargerDataSourceImpl
import com.example.myevcharger.data.paging.EvChargerPagingSource
import com.example.myevcharger.data.remote.datasource.RemoteEvChargerDataSourceImpl
import com.example.myevcharger.data.remote.model.EvChargerResponse
import com.example.myevcharger.domain.model.EvCharger
import com.example.myevcharger.domain.repository.EvChargerRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

// EvChargerRepository is consumed from other layers of the hierarchy.
class EvChargerRepositoryImpl @Inject constructor(
    private val evChargerLocalDataSource: LocalEvChargerDataSourceImpl,
    private val evChargerRemoteDataSource: RemoteEvChargerDataSourceImpl,
    private val evChargerApi: EvChargerApi
): EvChargerRepository {
/*
    override suspend fun getAllCharger() =
        evChargerRemoteDataSource.getAllCharger()
*/

    override suspend fun getAllCharger(): Flow<PagingData<EvCharger>> {
        return Pager(PagingConfig(PAGE_SIZE)) {
            EvChargerPagingSource(evChargerApi = evChargerApi)
        }.flow
    }

    override suspend fun upsert(evCharger: EvCharger) =
        evChargerLocalDataSource.upsert(evCharger)

    override fun getSavedEvCharger() =
        evChargerLocalDataSource.getSavedEvCharger()

    override suspend fun isSavedCharger(statId: Int): Boolean =
        evChargerLocalDataSource.isSavedCharger(statId)

    override suspend fun deleteCharger(statId: Int) =
        evChargerLocalDataSource.deleteCharger(statId)
}