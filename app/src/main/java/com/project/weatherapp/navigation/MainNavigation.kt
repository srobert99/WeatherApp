package com.project.weatherapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.project.weatherapp.screens.DayWeatherScreen.DayWeatherContent
import com.project.weatherapp.screens.MainScreen.MainScreen
import com.project.weatherapp.view_model.WeatherViewModel

@Composable
fun MainNavGraph(
    navController: NavHostController,
    weatherViewModel: WeatherViewModel
) {
    NavHost(
        navController = navController,
        startDestination = "MainScreen"
    ) {
        composable("MainScreen") {
            MainScreen(navController, weatherViewModel)
        }
        composable("DayDescriptionScreen") {
            DayWeatherContent()
        }
    }
}