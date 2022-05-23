package com.project.weatherapp.screens.MainScreen

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.project.weatherapp.R

@Composable
fun MainTopAppBar(navController: NavController) {
    TopAppBar(backgroundColor = colorResource(id = R.color.light_blue), elevation = 0.dp) {
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(Icons.Filled.ArrowBack, "back arrow")
        }
    }
}