package com.example.myevcharger.domain.di

import com.example.myevcharger.data.repository.EvChargerRepositoryImpl
import com.example.myevcharger.domain.repository.EvChargerRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindEvChargerRepository(
        evChargerRepositoryImpl: EvChargerRepositoryImpl
    ): EvChargerRepository
}