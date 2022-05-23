package com.project.weatherapp.screens.MainScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CompareArrows
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.project.weatherapp.R
import com.project.weatherapp.commons.CityEditableText
import com.project.weatherapp.commons.clearFocusOnKeyboardDismiss
import com.project.weatherapp.view_model.WeatherViewModel


@Composable
fun MainScreenContent(navController: NavController, weatherViewModel: WeatherViewModel) {
    val measurementResource = remember { mutableStateOf(R.string.celsius_measurement) }
    val measurement = stringResource(id = measurementResource.value)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        colorResource(id = R.color.light_blue),
                        colorResource(id = R.color.white_blue)
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(bottom = 150.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                CityEditableText(modifier = Modifier.clearFocusOnKeyboardDismiss(), enabled = true)
            }
            Text("Sunny", fontSize = 18.sp)
            Image(
                painter = painterResource(id = R.drawable.sunny_weather_icon),
                contentDescription = "icon weather",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(200.dp)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 40.dp)
            ) {
                Text(
                    "3 $measurement",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
                IconButton(onClick = {
                    measurementResource.value = changeMeasurement(measurementResource.value)
                }) {
                    Icon(Icons.Filled.CompareArrows, "Switch measurement button")
                }
            }
        }
        MainScreenBottomBar(
            modifier = Modifier.align(Alignment.BottomCenter),
            measurementResource = measurementResource.value,
            navController = navController
        )
    }
}

private fun changeMeasurement(currentMeasurement: Int): Int =
    if (currentMeasurement == R.string.celsius_measurement) {
        R.string.fahrenheit_measurement
    } else {
        R.string.celsius_measurement
    }
