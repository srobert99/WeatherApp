package com.project.weatherapp.view_model

import androidx.lifecycle.ViewModel
import com.project.weatherapp.repository.WeatherRepository

class WeatherViewModel(weatherRepository: WeatherRepository) : ViewModel() {

    var x = 0

    init {
        x = weatherRepository.getNumber()
    }

}