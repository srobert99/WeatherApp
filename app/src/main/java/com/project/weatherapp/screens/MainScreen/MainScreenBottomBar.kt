package com.project.weatherapp.screens.MainScreen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.project.weatherapp.R
import com.project.weatherapp.commons.celsiusToFehrenheit
import com.project.weatherapp.commons.listOfDayOfTheWeekWeatherMock
import com.project.weatherapp.models.WeekWeatherMock.DayOfWeekWeatherMock
import com.project.weatherapp.screens.Screen

@Composable
fun MainScreenBottomBar(
    modifier: Modifier = Modifier,
    navController: NavController,
    measurement: String
) {
    MainScreenBottomBarContent(modifier, measurement, navController)
}

@Composable
private fun MainScreenBottomBarContent(
    modifier: Modifier,
    measurement: String,
    navController: NavController
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 5.dp)
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        for (item in listOfDayOfTheWeekWeatherMock) {
            MainScreenBottomBarItem(
                measurement = measurement,
                navController = navController,
                dayOfWeekWeather = item
            )
        }
    }
}

@Composable
private fun MainScreenBottomBarItem(
    measurement: String,
    navController: NavController,
    dayOfWeekWeather: DayOfWeekWeatherMock
) {
    val isConvertedToFahrenheit =
        measurement == stringResource(id = R.string.fahrenheit_measurement)
    var weatherIconResource = R.drawable.sunny_weather_icon

    when (dayOfWeekWeather.temperature) {
        in (25..30) -> weatherIconResource = R.drawable.hot_weather_icon
        in (15..24) -> weatherIconResource = R.drawable.sunny_weather_icon
        in (9..14) -> weatherIconResource = R.drawable.cloudy_weather_icon
        in (1..8) -> weatherIconResource = R.drawable.rainy_weather_icon
        in (-99..0) -> weatherIconResource = R.drawable.snowy_weather_icon
    }

    Card(
        backgroundColor = Color.Transparent,
        elevation = 0.dp,
        border = BorderStroke(2.dp, color = Color.White),
        modifier = Modifier
            .clickable { navController.navigate(Screen.DayWeatherDetailsScreen.route + "/${dayOfWeekWeather.id}") }
            .width(100.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = dayOfWeekWeather.dayOfWeek, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Image(
                painter = painterResource(weatherIconResource),
                modifier = Modifier.size(50.dp),
                contentDescription = "weather icon"
            )
            Row {
                Text(
                    "${dayOfWeekWeather.temperature.celsiusToFehrenheit(isConvertedToFahrenheit)} $measurement",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}