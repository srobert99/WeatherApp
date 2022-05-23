package com.project.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.project.weatherapp.screens.MainScreen.MainScreen
import com.project.weatherapp.ui.theme.WeatherAppTheme

class MainActivity : ComponentActivity() {

    private lateinit var navHostController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme {
                navHostController = rememberNavController()
                MainScreen(mainNavController = navHostController)
            }
        }
    }
}