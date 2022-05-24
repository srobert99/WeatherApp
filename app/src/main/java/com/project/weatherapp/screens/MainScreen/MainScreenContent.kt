package com.project.weatherapp.screens.MainScreen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CompareArrows
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.project.weatherapp.R
import com.project.weatherapp.commons.CityEditableText
import com.project.weatherapp.commons.capitalizeWords
import com.project.weatherapp.commons.celsiusToFehrenheit
import com.project.weatherapp.commons.clearFocusOnKeyboardDismiss
import com.project.weatherapp.screens.Screen
import com.project.weatherapp.view_model.WeatherViewModel


@Composable
fun MainScreenContent(
    navController: NavController,
    weatherViewModel: WeatherViewModel,
) {
    val currentWeather by weatherViewModel.currentCityWeatherDetails.collectAsState()
    val currentCity by weatherViewModel.currentCity.collectAsState()
    val error by weatherViewModel.error.collectAsState()

    val context = LocalContext.current
    val weatherDescription = currentWeather?.weather?.first()?.description ?: "Status not found"
    val temperature = (currentWeather?.main?.temp?.toInt() ?: -1)
    var weatherIconResource = R.drawable.sunny_weather_icon
    val isFahrenheitMeasurementEnabled = remember { mutableStateOf(false) }
    val measurement =
        stringResource(
            id = if (isFahrenheitMeasurementEnabled.value) R.string.fahrenheit_measurement
            else R.string.celsius_measurement
        )

    when (temperature) {
        in (25..30) -> weatherIconResource = R.drawable.hot_weather_icon
        in (15..24) -> weatherIconResource = R.drawable.sunny_weather_icon
        in (9..14) -> weatherIconResource = R.drawable.cloudy_weather_icon
        in (1..8) -> weatherIconResource = R.drawable.rainy_weather_icon
        in (-99..0) -> weatherIconResource = R.drawable.snowy_weather_icon
    }

    if (error.isNotEmpty()) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
        weatherViewModel.resetErrorMessage()
    }

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
                .padding(bottom = 150.dp)
                .clickable { navController.navigate(Screen.DayWeatherDetailsScreen.route + "/99") },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                CityEditableText(
                    modifier = Modifier.clearFocusOnKeyboardDismiss(),
                    currentText = currentCity,
                    onTextChange = { weatherViewModel.onCityNameChanged(it) },
                    onFocusChanged = { weatherViewModel.getCityWeatherDetails() }
                )
            }
            Text(weatherDescription.capitalizeWords(), fontSize = 18.sp)
            Image(
                painter = painterResource(weatherIconResource),
                contentDescription = "icon weather",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(200.dp)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 40.dp)
            ) {
                Text(
                    "${temperature.celsiusToFehrenheit(isFahrenheitMeasurementEnabled.value)} $measurement",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
                IconButton(onClick = {
                    isFahrenheitMeasurementEnabled.value = !(isFahrenheitMeasurementEnabled.value)
                }) {
                    Icon(Icons.Filled.CompareArrows, "Switch measurement button")
                }
            }
        }
        MainScreenBottomBar(
            modifier = Modifier.align(Alignment.BottomCenter),
            measurement = measurement,
            navController = navController
        )
    }
}
