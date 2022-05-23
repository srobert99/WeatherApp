package com.project.weatherapp.screens.MainScreen

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.project.weatherapp.navigation.MainNavGraph
import com.project.weatherapp.view_model.WeatherViewModel

@Composable
fun MainNavigation(mainNavController: NavHostController, weatherViewModel: WeatherViewModel) {
    val navBackStackEntry by mainNavController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination?.route ?: "MainScreen"

    Scaffold(topBar = {
        if (currentDestination != "MainScreen") MainTopAppBar(navController = mainNavController)
    }) {
        MainNavGraph(navController = mainNavController,weatherViewModel)
    }
}