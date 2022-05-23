package com.project.weatherapp.models.CurrentWeather

data class Sys(
    val country: String,
    val id: Int,
    val sunrise: Int,
    val sunset: Int,
    val type: Int
)