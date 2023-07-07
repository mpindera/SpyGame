package com.example.gamespy

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ListItem
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gamespy.data.ViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DetailScreen(placesID: String) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {

        val viewModelInfoPlace: ViewModel = viewModel()
        val items = viewModelInfoPlace.readAlldata.observeAsState(listOf()).value.toMutableList()


        Text(
            text = stringResource(R.string.textPlaces),
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp, start = 16.dp, bottom = 25.dp),
            fontSize = 25.sp,
        )

        Column(modifier = Modifier.fillMaxSize()) {

            Spacer(modifier = Modifier.padding(bottom = 45.dp))

            LazyColumn {
                val filteredPlaces = items
                    .filter { item -> item.info.nameInfo == placesID }

                itemsIndexed(filteredPlaces) { index, place ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        elevation = 10.dp
                    ) {
                        ListItem(
                            text = {
                                Text(
                                    textAlign = TextAlign.Center,
                                    fontSize = 19.sp,
                                    modifier = Modifier.padding(5.dp),
                                    text = place.placeNames.toString().replace("[", "")
                                        .replace("]", "")
                                )
                            },
                            icon = {
                                IconButton(onClick = {
                                    viewModelInfoPlace.deleteInfo(place.info)
                                    viewModelInfoPlace.deletePlace(place.places)
                                }) {
                                    Icon(
                                        Icons.Default.Delete, contentDescription = null
                                    )
                                }
                            },
                        )
                    }
                }
            }
        }
    }
}


