package com.example.myevcharger.data.repository

import com.example.myevcharger.data.local.datasource.LocalEvChargerDataSourceImpl
import com.example.myevcharger.data.remote.datasource.RemoteEvChargerDataSourceImpl
import com.example.myevcharger.domain.model.EvCharger
import com.example.myevcharger.domain.repository.EvChargerRepository
import javax.inject.Inject

// EvChargerRepository is consumed from other layers of the hierarchy.
class EvChargerRepositoryImpl @Inject constructor(
    private val evChargerLocalDataSource: LocalEvChargerDataSourceImpl,
    private val evChargerRemoteDataSource: RemoteEvChargerDataSourceImpl
): EvChargerRepository {
    override suspend fun getAllCharger() =
        evChargerRemoteDataSource.getAllCharger()

    override suspend fun upsert(evCharger: EvCharger) = evChargerLocalDataSource.upsert(evCharger)

    override fun getSavedEvCharger() = evChargerLocalDataSource.getSavedEvCharger()
}