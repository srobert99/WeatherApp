package com.project.weatherapp.models.CurrentWeather

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)