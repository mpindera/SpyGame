package com.example.gamespy.data

import android.provider.ContactsContract.Data
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DaoPlace {
    @Query("SELECT * FROM DataPlace")
    fun getAllLiveData(): LiveData<List<DataPlace>>

    @Query("SELECT * FROM DataPlace WHERE id IN (:place)")
    fun loadAllByIds(place: IntArray): List<DataPlace>

    @Insert
    suspend fun insertData(dataPlace: DataPlace)

    @Delete
    suspend fun deleteData(dataPlace: DataPlace)
}