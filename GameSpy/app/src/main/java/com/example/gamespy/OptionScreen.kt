package com.example.gamespy

import android.app.Application
import android.widget.Space
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.viewModelFactory

import androidx.navigation.NavController
import com.example.gamespy.data.ViewModel
import com.example.gamespy.data.entity.AppDatabase
import com.example.gamespy.data.entity.Info
import com.example.gamespy.data.entity.Place

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OptionScreen(navController: NavController) {

    val context = LocalContext.current
    val viewModelInfoPlace: ViewModel = viewModel()

    val items = viewModelInfoPlace.readAlldata.observeAsState(listOf()).value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items.forEach { infoPlace ->

            Text(text = "Group: ${infoPlace.info.nameInfo} |  ${infoPlace.places}")
            
        }

        Text(text = "Adding elements to game")
        Spacer(modifier = Modifier.padding(bottom = 15.dp))
        AddingElements(viewModelInfoPlace)
        Spacer(modifier = Modifier.padding(bottom = 15.dp))
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddingElements(viewModel: ViewModel) {

    var textInfo by remember {
        mutableStateOf("")
    }

    var textPlaces by remember {
        mutableStateOf("")
    }


    /*val infoTextField = Info(nameInfo = "Place1")

    val infoId = infoTextField.infoID

    val placesTextField = Place(infoID = infoId, namePlaces = "Dom")*/

    OutlinedTextField(
        value = textInfo,
        onValueChange = { textInfo = it },
        label = { Text(text = "Info") }
    )

    Spacer(modifier = Modifier.padding(bottom = 15.dp))

    OutlinedTextField(
        value = textPlaces,
        onValueChange = { textPlaces = it },
        label = { Text(text = "Places") }
    )
    val infoTextField = Info(nameInfo = textInfo)

    val infoId = infoTextField.infoID

    /*val placesTextField = Place(infoID = infoId, namePlaces = textPlaces)*/
    val placesTextField = Place(infoID = infoId, namePlaces = "Dom")

    Button(onClick = {
        viewModel.insertInfo(infoTextField)
        viewModel.insertPlace(placesTextField)
        /* viewModel.deleteAllInfo()
         viewModel.deleteAllPlaces()*/
    }) {

        Text(text = "Add")

    }

}











