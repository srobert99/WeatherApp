package com.project.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.project.weatherapp.di.appModules
import com.project.weatherapp.di.weatherViewModel
import com.project.weatherapp.screens.MainScreen.MainScreen
import com.project.weatherapp.ui.theme.WeatherAppTheme
import com.project.weatherapp.view_model.WeatherViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.core.context.startKoin

class MainActivity : ComponentActivity() {

    private lateinit var navHostController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startKoin {
            androidContext(this@MainActivity)
            modules(listOf(appModules, weatherViewModel))
        }

        val weatherViewModel = getViewModel<WeatherViewModel>()

        setContent {
            navHostController = rememberNavController()
            WeatherAppTheme {
                MainScreen(mainNavController = navHostController, weatherViewModel)
            }
        }
    }
}