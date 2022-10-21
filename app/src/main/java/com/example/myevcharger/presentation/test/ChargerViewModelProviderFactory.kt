package com.example.myevcharger.presentation.test

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myevcharger.data.local.repository.LocalEvChargerRepositoryImpl

class ChargerViewModelProviderFactory(
    val chargerRepositoryImpl: LocalEvChargerRepositoryImpl
) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RepoTestViewModel(chargerRepositoryImpl) as T
    }
}