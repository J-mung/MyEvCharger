package com.example.myevcharger.domain.di

import android.content.Context
import androidx.room.Room
import com.example.myevcharger.data.local.dao.EvChargerDao
import com.example.myevcharger.data.local.database.EvChargerDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun providesEvChargerDatabase(
        @ApplicationContext context: Context
    ): EvChargerDatabase =
        Room.databaseBuilder(context, EvChargerDatabase::class.java, "ev_charger_db.db")
            .build()

    @Singleton
    @Provides
    fun providesEvChargerDao(
        evChargerDatabase: EvChargerDatabase
    ): EvChargerDao = evChargerDatabase.getEvChargerDao()
}