package com.example.myevcharger.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.myevcharger.data.remote.model.EvChargerResponse
import com.example.myevcharger.domain.model.EvCharger
import com.example.myevcharger.domain.repository.EvChargerRepository
import com.example.myevcharger.presentation.base.BaseViewModel
import com.example.myevcharger.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val evChargerRepository: EvChargerRepository
) : BaseViewModel() {

    private val _evChargerList: MutableStateFlow<PagingData<EvCharger>> =
        MutableStateFlow(PagingData.empty())
    val evChargerList: StateFlow<PagingData<EvCharger>>
        get() = _evChargerList

    var convertedList: List<EvCharger>? = null

    // paging이 필요한 부분인가?
    // -> 자동 페이징이냐 수동 페이징이냐 일단 수동 ㄱㄱ
    // -> 수동 알고 있는 방법으로 했을 때 EvCharger로 binding 하는 법 몰라서 자동으로 함 시도
    fun getAllCharger() {
        viewModelScope.launch {
            evChargerRepository.getAllCharger()
                .cachedIn(viewModelScope)
                .collect {
                    _evChargerList.value = it
                }
        }
    }

    fun bindFlowToList() {
        viewModelScope.launch {
            var currentList = mutableListOf<EvCharger>()

            val evChargerFlow = evChargerRepository.getAllCharger()
                .mapNotNull { pagingData ->
                    pagingData.map { newValue ->

                    }

                }
        }
    }

/*
    private fun handleEvChargerResponse(response: Response<EvChargerResponse>): Resource<EvChargerResponse>? {
        if(response.isSuccessful) {
            response.body()?.let { resultResponse ->
                evChargerPage++
                if(evChargerResponse == null) {
                    evChargerResponse = resultResponse
                } else {
                    val oldChargers = evChargerResponse?.evChargers
                    val newChargers = resultResponse.evChargers
                    oldChargers?.addAll(newChargers)
                }
                return Resource.Success(evChargerResponse ?: resultResponse)
            }
        }
        return Resource.Error(response.message())
    }
*/

    suspend fun getSavedEvCharger() = evChargerRepository.getSavedEvCharger()

    companion object {
        private const val TAG = "MainViewModel"
    }
}