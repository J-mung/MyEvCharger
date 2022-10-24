package com.example.myevcharger.data.remote.datasource

import com.example.myevcharger.data.remote.model.EvChargerResponse
import retrofit2.Response

interface RemoteEvChargerDataSource {
    suspend fun getAllCharger() : Response<EvChargerResponse>
}