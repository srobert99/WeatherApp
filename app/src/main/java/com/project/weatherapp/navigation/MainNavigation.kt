package com.project.weatherapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.project.weatherapp.screens.DayWeatherScreen.DayWeatherContent
import com.project.weatherapp.screens.MainScreen.MainScreenContent

@Composable
fun MainNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = "MainScreen"
    ) {
        composable("MainScreen") {
            MainScreenContent(navController)
        }
        composable("DayDescriptionScreen") {
            DayWeatherContent()
        }
    }
}