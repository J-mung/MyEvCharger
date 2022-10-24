package com.example.myevcharger.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.myevcharger.domain.repository.EvChargerRepository
import com.example.myevcharger.presentation.base.BaseViewModel
import com.example.myevcharger.utils.Resource
import com.skt.tmap.poi.EvCharger
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val evChargerRepository: EvChargerRepository
): BaseViewModel() {
    private val _evChargerList: MutableLiveData<Resource<EvCharger>> =
        MutableLiveData()
    val evChargerList: LiveData<Resource<EvCharger>>
        get() = _evChargerList

    // paging이 필요한 부분인가?
    fun getAllCharger() {
        viewModelScope.launch {
            evChargerRepository.getAllCharger()
        }
    }

    companion object {
        private const val TAG = "MainViewModel"
    }
}