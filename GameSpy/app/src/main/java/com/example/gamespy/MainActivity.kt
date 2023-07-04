package com.example.gamespy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gamespy.ui.theme.GameSpyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GameSpyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    val navController = rememberNavController()
                    NavigationAppHost(navController)

                }
            }
        }
    }
}

@Composable
fun NavigationAppHost(navController: NavHostController) {
    val selectedOptionState: MutableState<String> = remember { mutableStateOf("") }

    NavHost(
        navController = navController,
        startDestination = Destination.StartScreenDestination.route
    ) {
        composable(Destination.StartScreenDestination.route) {
            StartScreen(
                navController = navController,
                selectedOption = selectedOptionState.value,
                onSelectedOptionChange = { selectedOption ->
                    selectedOptionState.value = selectedOption
                }
            )
        }
        composable(Destination.GameScreenDestination.route) {
            GameHome(
                navController = navController,
                selectedOption = selectedOptionState.value
            )
        }

    }
}
