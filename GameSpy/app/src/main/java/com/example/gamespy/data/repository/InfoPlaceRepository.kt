package com.example.gamespy.data.repository

import androidx.lifecycle.LiveData
import com.example.gamespy.data.entity.DaoInfo
import com.example.gamespy.data.entity.Info
import com.example.gamespy.data.entity.Place

class InfoPlaceRepository(private val daoInfo: DaoInfo) {

    suspend fun insertInfo(info: Info) {
        daoInfo.insertInfo(info)
    }

    suspend fun insertPlace(place: Place) {
        daoInfo.insertPlace(place)
    }

    suspend fun deleteInfo(info: Info) {
        daoInfo.deleteInfo(info)
    }

    suspend fun deletePlace(place: List<Place>) {
        daoInfo.deletePlace(place)
    }


    fun getAllInfoPlace(): LiveData<List<Place>> = daoInfo.getAllInfoPlace()

    fun getAllInfo(): LiveData<List<Info>> = daoInfo.getAllInfo()

    suspend fun deleteAllInfo() = daoInfo.deleteAllInfo()

    suspend fun deleteAllPlaces() = daoInfo.deleteAllPlaces()

    fun getAllInfoWithPlaces() = daoInfo.getAllInfoWithPlaces()


}