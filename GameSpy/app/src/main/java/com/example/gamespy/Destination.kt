package com.example.gamespy

sealed class Destination(val route: String) {
    object StartScreenDestination : Destination("startScreen")
    object GameScreenDestination : Destination("gameScreen")
}
