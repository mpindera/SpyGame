package com.example.gamespy.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CartViewModel(application: Application) : AndroidViewModel(application) {

    private val daoPlace: DataPlaceRepository

    val place: LiveData<List<DataPlace>>

    init {
        val database = AppDatabase.getInstance(application).DaoPlace()
        daoPlace = DataPlaceRepository(database)
        place = daoPlace.readAllData
    }

    fun insertPlace(place: DataPlace) {
        viewModelScope.launch(Dispatchers.IO) {
            daoPlace.addData(place)
        }
    }
    fun deletePlace(place: DataPlace) {
        viewModelScope.launch(Dispatchers.IO) {
            daoPlace.deleteData(place)
        }
    }


}