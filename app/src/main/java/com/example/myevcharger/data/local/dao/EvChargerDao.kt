package com.example.myevcharger.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myevcharger.domain.model.EvCharger

@Dao
interface EvChargerDao {

    @Query("SELECT * FROM evChargers")
    fun getAllCharger(): LiveData<List<EvCharger>>

    /*@Query("SELECT * FROM evChargers WHERE zcode =:zcode")
    fun getChargerZcode(zcode: Int): LiveData<List<EvCharger>>*/

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(evCharger: EvCharger): Long
/*
    @Query("SELECT EXISTS(SELECT * FROM evChargers WHERE statId =:statId)")
    suspend fun isSavedCharger(statId: Int): Boolean

    @Query("DELETE FROM evChargers WHERE statId =:statId")
    suspend fun deleteCharger(statId: Int)
*/

    /*
    @Delete
    suspend fun deleteCharger(evCharger: EvCharger)
    */
}