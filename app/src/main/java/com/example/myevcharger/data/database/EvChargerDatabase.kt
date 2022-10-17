package com.example.myevcharger.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
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

    companion object {
        @Volatile
        private var instance: EvChargerDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also{ instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                EvChargerDatabase::class.java,
                "ev_charger_db.db"
            ).build()
    }
}