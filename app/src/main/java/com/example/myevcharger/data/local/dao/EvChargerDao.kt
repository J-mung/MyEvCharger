package com.example.myevcharger.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myevcharger.domain.model.EvCharger
import kotlinx.coroutines.flow.Flow

@Dao
interface EvChargerDao {

    @Query("SELECT * FROM evChargers")
    suspend fun getAllCharger(): Flow<List<EvCharger>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCharger(evCharger: EvCharger)

    @Query("SELECT EXISTS(SELECT * FROM evChargers WHERE statId =:statId)")
    suspend fun isSavedCharger(statId: Int): Boolean

    @Query("DELETE FROM evChargers WHERE statId =:statId")
    suspend fun deleteCharger(statId: Int)

    /*
    @Delete
    suspend fun deleteCharger(evCharger: EvCharger)
    */
}