package com.project.weatherapp.screens.MainScreen

import androidx.annotation.StringRes
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
import com.project.weatherapp.models.WeekWeatherMock.DayOfWeekWeatherMock

@Composable
fun MainScreenBottomBar(
    modifier: Modifier = Modifier,
    navController: NavController,
    @StringRes measurementResource: Int = R.string.celsius_measurement
) {
    MainScreenBottomBarContent(modifier, measurementResource, navController)
}

@Composable
private fun MainScreenBottomBarContent(
    modifier: Modifier,
    @StringRes measurementResource: Int,
    navController: NavController
) {
    val listOfDayOfTheWeekWeatherMock = listOf(
        DayOfWeekWeatherMock("WED", 20, 15, 25, "23", ""),
        DayOfWeekWeatherMock("THU", 22, 18, 26, "20", "30"),
        DayOfWeekWeatherMock("FRI", 25, 13, 29, "22", "30"),
        DayOfWeekWeatherMock("SAT", 19, 12, 20, "28", "30"),
        DayOfWeekWeatherMock("SUN", 22, 11, 24, "29", "30"),
        DayOfWeekWeatherMock("MON", 24, 10, 28, "22", "30"),
        DayOfWeekWeatherMock("TUE", 19, 13, 22, "30", "30"),
    )
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 5.dp)
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        for (item in listOfDayOfTheWeekWeatherMock) {
            MainScreenBottomBarItem(
                measurementResource = measurementResource,
                navController = navController,
                dayOfWeekWeather = item
            )
        }
    }
}


@Composable
private fun MainScreenBottomBarItem(
    @StringRes measurementResource: Int = R.string.celsius_measurement,
    navController: NavController,
    dayOfWeekWeather: DayOfWeekWeatherMock
) {
    val measurement = stringResource(id = measurementResource)
    Card(
        backgroundColor = Color.Transparent,
        elevation = 0.dp,
        border = BorderStroke(2.dp, color = Color.White),
        modifier = Modifier
            .clickable { navController.navigate("DayDescriptionScreen") }
            .width(100.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = dayOfWeekWeather.dayOfWeek, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Image(
                painter = painterResource(id = R.drawable.sunny_weather_icon),
                modifier = Modifier.size(50.dp),
                contentDescription = "weather icon"
            )
            Row {
                Text(
                    "${dayOfWeekWeather.temperature} $measurement",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}