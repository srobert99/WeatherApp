package com.project.weatherapp.screens

sealed class Screen(val route: String) {
    object MainScreen : Screen("main_screen")
    object DayWeatherDetailsScreen : Screen("day_weather_details}")
}