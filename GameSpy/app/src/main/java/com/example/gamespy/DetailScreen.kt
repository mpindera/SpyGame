package com.example.gamespy

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.gamespy.data.ViewModel

@Composable
fun DetailScreen(placesID: String) {
    val viewModelInfoPlace: ViewModel = viewModel()
    val items = viewModelInfoPlace.readAlldata.observeAsState(listOf()).value

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        LazyColumn {
            items(items) { item ->
                if (item.info.nameInfo == placesID) {
                    Text(text = item.placeNames.toString())
                }

            }
        }
    }

}
