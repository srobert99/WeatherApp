package com.project.weatherapp.models.CurrentWeather

data class Main(
    val feelslike: Double,
    val humidity: Int,
    val pressure: Int,
    val temp: Double,
    val temp_max: Double,
    val tempmin: Double
)