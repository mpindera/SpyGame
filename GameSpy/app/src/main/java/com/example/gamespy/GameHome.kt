package com.example.gamespy

import android.app.AlertDialog
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.example.gamespy.data.BoxPeople

@Composable
fun GameHome(navController: NavHostController, selectedOption: String) {

    BackHandler(enabled = true) {

    }
    val place: MutableList<String> = mutableListOf(
        "Kino",
        "Teatr",
        "Park",
        "Muzeum",
        "Opera",
        "Kawiarnia",
        "Plaża",
        "Centrum handlowe",
        "Stadion",
        "Biblioteka",
        "Klub nocny",
        "Zamek",
        "Skatepark",
        "Ogród botaniczny",
        "Aquapark",
        "Pole golfowe",
        "Wieża widokowa",
        "Skwer",
        "Zoo",
        "Wesołe miasteczko",
        "Planetarium",
        "Restauracja",
        "Kawiarnia",
        "Hala widowiskowa",
        "Teren rekreacyjny",
        "Łaźnie termalne",
        "Jezioro",
        "Rzeka",
        "Galeria sztuki",
        "Skatepark",
        "Amfiteatr",
        "Punkt widokowy",
        "Basen",
        "Pole namiotowe",
        "Park linowy",
        "Teatr tańca",
        "Sala koncertowa",
        "Kawiarnia artystyczna",
        "Muzeum historii",
        "Kino"
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val selectedNumber = selectedOption.toInt()

        val numList = (1..selectedNumber).toMutableList()

        numList.shuffle()
        val rows = numList.chunked(3)

        val randomNum = (1..40).random()

        val randomSpyNum = numList.random()

        val context = LocalContext.current

        val builder = AlertDialog.Builder(context)

        rows.forEach { number ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                number.forEach { num ->
                    val numRandom = numList[num - 1];
                    BoxPeople(
                        onClick = {
                            if (numRandom == randomSpyNum) {
                                alertDialog(builder = builder, "Spy")
                            } else {
                                alertDialog(builder = builder, place[randomNum])
                            }
                        }
                    )
                }
            }
        }

        Button(onClick = {
            navController.popBackStack()
            navController.navigate("startScreen")
        }) {
            Text(text = "End the Game")
        }
    }
}

private fun alertDialog(builder: AlertDialog.Builder, text: String) {
    builder.setTitle(text)
        .setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
        }
    val dialog = builder.create()
    dialog.show()
}


