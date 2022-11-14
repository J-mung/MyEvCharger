package com.example.myevcharger.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.myevcharger.data.api.EvChargerApi
import com.example.myevcharger.data.mapper.RemoteMapper
import com.example.myevcharger.domain.model.EvCharger
import kotlinx.coroutines.delay

class EvChargerPagingSource(
    private val evChargerApi: EvChargerApi,
): PagingSource<Int, EvCharger>() {

    override fun getRefreshKey(state: PagingState<Int, EvCharger>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, EvCharger> {
        return try {
            // Start refresh at page 1 if underfined.
            val curKey = params.key ?: START_KEY

            if (curKey != START_KEY) delay(DELAY_MILLIS)

            val evChargerList = evChargerApi.getEvChargers(pageNo = curKey)
                .evChargers!!.map { evChargerApiModel ->
                    RemoteMapper.mapToDomainEvCharger(evChargerApiModel = evChargerApiModel)
                }
            LoadResult.Page(
                data = evChargerList,
                prevKey = if (curKey == START_KEY) null else curKey - 1,
                nextKey = if (evChargerList.isEmpty()) null else curKey + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    companion object {
        const val START_KEY = 1
        const val DELAY_MILLIS = 1_000L
        const val TAG = "EvChargerPagingSource"
    }
}