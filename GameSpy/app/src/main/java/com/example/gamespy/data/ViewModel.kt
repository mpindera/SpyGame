package com.example.gamespy.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.gamespy.data.entity.AppDatabase
import com.example.gamespy.data.entity.Info
import com.example.gamespy.data.entity.Place
import com.example.gamespy.data.entity.relation.InfoWithPlaces
import com.example.gamespy.data.repository.InfoPlaceRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ViewModel(application: Application) : AndroidViewModel(application) {

    val readAlldata: LiveData<List<InfoWithPlaces>>
    private val repository: InfoPlaceRepository

    init {
        val daoInfo = AppDatabase.getInstance(application).daoInfo()
        repository = InfoPlaceRepository(daoInfo)
        readAlldata = repository.getAllInfoWithPlaces()
    }

    fun insertInfo(info: Info) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repository.insertInfo(info)
            }
        }
    }

    fun insertPlace(place: Place) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repository.insertPlace(place)
            }
        }
    }

    fun deleteInfo(info: Info) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteInfo(info)
        }
    }

    fun deletePlace(place: List<Place>) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deletePlace(place)
        }
    }

    fun getAllInfoPlace() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllInfoPlace()
        }
    }

    fun getAllInfo() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllInfo()
        }
    }

    fun deleteAllInfo() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllInfo()
        }
    }

    fun deleteAllPlaces() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllPlaces()
        }
    }


}
