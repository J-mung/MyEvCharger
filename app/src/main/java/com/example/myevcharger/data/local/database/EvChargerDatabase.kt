package com.example.myevcharger.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myevcharger.data.local.dao.EvChargerDao
import com.example.myevcharger.domain.model.EvCharger

@Database(
    entities = [EvCharger::class],
    version = 1,
    exportSchema = false
)

abstract class EvChargerDatabase: RoomDatabase() {
    abstract fun getEvChargerDao(): EvChargerDao
}