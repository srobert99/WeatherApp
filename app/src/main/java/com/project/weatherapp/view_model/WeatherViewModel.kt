package com.project.weatherapp.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.weatherapp.models.CurrentWeather.CurrentWeather
import com.project.weatherapp.repository.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Response

class WeatherViewModel(val weatherRepository: WeatherRepository) : ViewModel() {

    private val _currentCity = MutableStateFlow("Sibiu")
    val currentCity: StateFlow<String> = _currentCity

    private val _currentCityWeatherDetails = MutableStateFlow<CurrentWeather?>(null)
    val currentCityWeatherDetails: StateFlow<CurrentWeather?> = _currentCityWeatherDetails

    private val _response = MutableSharedFlow<Response<CurrentWeather>?>(1)
    val response: SharedFlow<Response<CurrentWeather>?> = _response

    private val _error = MutableStateFlow("")
    val error: StateFlow<String> = _error

    private val _currentSelectedMeasurement = MutableStateFlow("metric")

    init {
        getCityWeatherDetails()
    }

    fun getCityWeatherDetails() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _response.emit(
                    weatherRepository.getCurrentWeather(
                        currentCity.value,
                        _currentSelectedMeasurement.value
                    )
                )
                _response.collect {
                    if (it!!.isSuccessful) {
                        _currentCityWeatherDetails.value = it.body()!!
                    } else {
                        _error.value = it.message().toString()
                    }
                }
            } catch (e: Exception) {
                _error.value = e.message!!
            }
        }
    }

    fun onCityNameChanged(newText: String) {
        _currentCity.value = newText
    }

    fun resetErrorMessage() {
        _error.value = ""
    }

}