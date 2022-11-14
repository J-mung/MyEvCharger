package com.example.myevcharger.data.remote.datasource

import com.example.myevcharger.data.api.EvChargerApi
import javax.inject.Inject

class RemoteEvChargerDataSourceImpl @Inject constructor(
    private val chargerApi: EvChargerApi    // from NetworkModule providesEvChargerApi()
) : RemoteEvChargerDataSource {
    override suspend fun getAllCharger() =
        chargerApi.getEvChargers()

    companion object {
        private const val TAG = "RemoteEvChargerDataSourceImpl"
        private const val PAGE_SIZE = 20
    }
}