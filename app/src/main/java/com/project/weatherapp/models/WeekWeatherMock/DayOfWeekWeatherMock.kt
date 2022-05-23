package com.project.weatherapp.models.WeekWeatherMock

data class DayOfWeekWeatherMock(
    val dayOfWeek: String,
    val temperature: Int,
    val minTemperature: Int,
    val maxTemperature: Int,
    val windPower: String,
    val pressure: String
)