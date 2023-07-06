package com.example.gamespy.data.entity

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.gamespy.data.entity.relation.InfoWithPlaces

@Dao
interface DaoInfo {

    @Insert
    suspend fun insertInfo(info: Info)

    @Insert
    suspend fun insertPlace(place: Place)

    @Delete
    suspend fun deleteInfo(info: Info)

    @Delete
    suspend fun deletePlace(place: Place)

    @Query("SELECT * FROM places_table")
    fun getAllInfoPlace(): LiveData<List<Place>>

    @Query("SELECT * FROM info_table")
    fun getAllInfo(): LiveData<List<Info>>

    //Delete
    @Query("DELETE FROM info_table")
    suspend fun deleteAllInfo()

    @Query("DELETE FROM places_table")
    suspend fun deleteAllPlaces()

    @Transaction
    @Query("SELECT * FROM info_table")
    fun getAllInfoWithPlaces(): LiveData<List<InfoWithPlaces>>


}