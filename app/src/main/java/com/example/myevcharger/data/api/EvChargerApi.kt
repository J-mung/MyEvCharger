package com.example.myevcharger.data.api

import com.example.myevcharger.data.remote.model.EvChargerApiModel
import com.example.myevcharger.data.remote.model.EvChargerResponse
import com.example.myevcharger.utils.Constants.Companion.EV_API_KEY
import com.example.myevcharger.utils.Constants.Companion.EV_DATA_TYPE
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import java.net.URLDecoder

/*
    SERVICE_KEY - > URL 인코딩을 진행합니다 - > 사용

    하지만 서비스키를 android studio에서 파라미터로 전달할 경우

    unsafe characters인 %가 포함되어 있어 SERVICE_KEY가

    변경되기 때문에 디코딩 작업이 필요합니다.

    apiKey: String = URLDecoder.decode(EV_API_KEY, "UTF-8"),
*/


interface EvChargerApi {
    @GET("getChargerInfo")
    suspend fun getEvChargers(
        @Query("serviceKey")
        apiKey: String = URLDecoder.decode(EV_API_KEY, "UTF-8"),
        @Query("numOfRows")
        numOfRows: Int = 10,
        @Query("pageNo")
        pageNo: Int = 1,
        @Query("dataType")
        dataType: String = EV_DATA_TYPE
    ): EvChargerResponse
}