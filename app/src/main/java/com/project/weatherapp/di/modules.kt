package com.project.weatherapp.di

import com.project.weatherapp.repository.WeatherRepository
import com.project.weatherapp.view_model.WeatherViewModel
import data_source.RetrofitInstance
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModules = module {
    single { RetrofitInstance() }
    single { WeatherRepository(get()) }
}

val weatherViewModel = module {
    viewModel { WeatherViewModel(get()) }
}
