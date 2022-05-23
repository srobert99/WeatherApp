package com.project.weatherapp.screens.MainScreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import com.project.weatherapp.screens.LoadingScreen.LoadingScreen
import com.project.weatherapp.view_model.WeatherViewModel

@Composable
fun MainScreen(navController: NavController, weatherViewModel: WeatherViewModel) {
    val errorMessage = remember { weatherViewModel.error.value }
    val responseBody by weatherViewModel.currentCityWeatherDetails.collectAsState()

    if (responseBody == null) {
        LoadingScreen()
    } else if (errorMessage.isNotEmpty()) {
        LoadingScreen(errorMessage)
    } else {
        MainScreenContent(navController = navController, weatherViewModel = weatherViewModel)
    }

}