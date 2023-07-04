package com.example.gamespy.data

import androidx.lifecycle.LiveData

class DataPlaceRepository(private val dataPlaceDatabase: DaoPlace) {
    val readAllData: LiveData<List<DataPlace>> = dataPlaceDatabase.getAllLiveData()

    suspend fun addData(addDataPlace: DataPlace) {
        dataPlaceDatabase.insertData(addDataPlace)
    }

    suspend fun deleteData(addDataPlace: DataPlace) {
        dataPlaceDatabase.deleteData(addDataPlace)
    }


}