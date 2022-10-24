package com.example.myevcharger.data.remote.datasource

import com.example.myevcharger.data.api.EvChargerApi
import javax.inject.Inject

// Api 객체를 외부에서 생성해서 가져오는 게 맞는건가?
// -> 일단 테스트는 해봐야 하니까 외부에서 가져오는거로 하자

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