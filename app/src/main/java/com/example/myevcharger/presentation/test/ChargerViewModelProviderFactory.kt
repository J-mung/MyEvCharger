package com.example.myevcharger.presentation.test

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myevcharger.data.remote.datasource.RemoteEvChargerDataSourceImpl
import com.example.myevcharger.data.repository.EvChargerRepositoryImpl

class ChargerViewModelProviderFactory(
    val chargerRepositoryImpl: EvChargerRepositoryImpl
) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RepoTestViewModel(chargerRepositoryImpl) as T
    }
}