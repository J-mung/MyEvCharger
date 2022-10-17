package com.example.myevcharger.data.api

import com.example.myevcharger.domain.model.EvChargerResponse
import com.example.myevcharger.utils.Constants.Companion.EV_API_KEY
import com.example.myevcharger.utils.Constants.Companion.EV_DATA_TYPE
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface EvChargerApi {
    @GET("/B552584/EvCharger/getChargerInfo")
    suspend fun getEvChargers(
        @Query("numOfRows")
        numOfRows: Int = 10,
        @Query("pageNo")
        pageNo: Int = 1,
        @Query("dataType")
        dataType: String = EV_DATA_TYPE,
        apiKey: String = EV_API_KEY
    ): Response<EvChargerResponse>
}