package com.project.weatherapp.repository

import com.project.weatherapp.models.CurrentWeather.CurrentWeather
import data_source.RetrofitInstance
import retrofit2.Response

class WeatherRepository(private val retrofitInstance: RetrofitInstance) {

    suspend fun getCurrentWeather(location: String, metric: String): Response<CurrentWeather> =
        retrofitInstance.weatherApi.getCurrentWeather(location, metric)
}
