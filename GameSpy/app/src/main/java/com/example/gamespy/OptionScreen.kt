package com.example.gamespy

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.navigation.NavController
import com.example.gamespy.data.ViewModel
import com.example.gamespy.data.entity.Info
import com.example.gamespy.data.entity.Place

@Composable
fun OptionScreen(navController: NavController) {

    val viewModelInfoPlace: ViewModel = viewModel()
    val items = viewModelInfoPlace.readAlldata.observeAsState(listOf()).value
    val listOfInfo: MutableSet<String> = mutableSetOf()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        items.forEach { infoPlace ->
            listOfInfo.add(infoPlace.info.nameInfo)
        }

        Text(text = "Adding elements to game")
        Spacer(modifier = Modifier.padding(bottom = 15.dp))
        AddingElements(viewModelInfoPlace, listOfInfo)
        Spacer(modifier = Modifier.padding(bottom = 15.dp))
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddingElements(viewModel: ViewModel, listOfInfo: MutableSet<String>) {

    val context = LocalContext.current

    var textInfo by remember {
        mutableStateOf("")
    }

    var textPlaces by remember {
        mutableStateOf("")
    }

    var isDropdownOpen by remember {
        mutableStateOf(false)
    }


    OutlinedTextField(
        value = textInfo,
        onValueChange = { textInfo = it },
        label = { Text(text = "Info") },
        leadingIcon = {
            IconButton(onClick = {
                isDropdownOpen = true
            }) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = "Add Icon",
                    tint = Color.Black
                )
                DropdownMenu(
                    expanded = isDropdownOpen,
                    onDismissRequest = { isDropdownOpen = false },
                    modifier = Modifier.width(100.dp)
                ) {
                    listOfInfo.forEach { selectedInfo ->
                        androidx.compose.material3.DropdownMenuItem(
                            text = { Text(text = selectedInfo) },
                            onClick = {
                                textInfo = selectedInfo
                                isDropdownOpen = false
                            }
                        )
                    }
                }
            }
        }
    )

    Spacer(modifier = Modifier.padding(bottom = 15.dp))

    OutlinedTextField(
        value = textPlaces,
        onValueChange = { textPlaces = it },
        label = { Text(text = "Places") }
    )

    val infoTextField = Info(nameInfo = textInfo)

    val placesTextField = Place(infoID = infoTextField.infoID, namePlaces = textPlaces)
    Row(
        modifier = Modifier.padding(top = 15.dp)
    ) {
        Button(colors = ButtonDefaults.buttonColors(Color(0xFEDFAC57)), onClick = {
            if (infoTextField.nameInfo != "" && placesTextField.namePlaces != "") {
                viewModel.insertInfo(infoTextField)
                viewModel.insertPlace(placesTextField)
            } else {
                Toast.makeText(context, "Fill Info.", Toast.LENGTH_SHORT).show()
            }
        }) {
            Text(text = "Add")
        }

        Spacer(modifier = Modifier.padding(15.dp))

        Button(colors = ButtonDefaults.buttonColors(Color(0xFEDFAC57)), onClick = {
            viewModel.deleteAllInfo()
            viewModel.deleteAllPlaces()
        }) {
            Text(text = "Delete all")
        }
    }


}











