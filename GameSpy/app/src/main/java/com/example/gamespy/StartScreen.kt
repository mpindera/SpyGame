package com.example.gamespy

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.gamespy.ui.theme.darkGray

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StartScreen(
    navController: NavHostController,
    selectedOption: String,
    onSelectedOptionChange: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        val options = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10")

        var isDropdownOpen by remember {
            mutableStateOf(false)
        }

        val context = LocalContext.current

        Box(modifier = Modifier.padding(16.dp)) {
            Column {
                Button(
                    onClick = { isDropdownOpen = !isDropdownOpen },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(darkGray)
                ) {
                    Text(
                        color = Color.Black,
                        fontSize = 20.sp,
                        text = selectedOption.takeUnless { it.isEmpty() } ?: "Select")
                }

                DropdownMenu(
                    expanded = isDropdownOpen,
                    onDismissRequest = { isDropdownOpen = false },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    options.forEach { selectedOptionText ->
                        DropdownMenuItem(
                            text = { Text(text = selectedOptionText) },
                            onClick = {
                                onSelectedOptionChange(selectedOptionText)
                                isDropdownOpen = false
                            },
                            contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                        )
                    }
                }
            }
        }
        Button(
            onClick = {
                if (selectedOption != "") {
                    navController.navigate("gameScreen")
                } else {
                    navController.navigate("startScreen")
                    Toast.makeText(context, "Choose number.", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier
                .padding(top = 30.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF867D7D))
        ) {
            Text(
                text = "Accept",
                fontSize = 20.sp,
                color = Color.Black
            )
        }
        Button(
            onClick = {
                navController.navigate("optionScreen")

            },
            modifier = Modifier
                .padding(top = 30.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF867D7D))
        ) {
            Text(
                text = "Option",
                fontSize = 20.sp,
                color = Color.Black
            )
        }
        Button(
            onClick = {
                navController.navigate("listScreen")

            },
            modifier = Modifier
                .padding(top = 30.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF867D7D))
        ) {
            Text(
                text = "List",
                fontSize = 20.sp,
                color = Color.Black
            )
        }
    }
}