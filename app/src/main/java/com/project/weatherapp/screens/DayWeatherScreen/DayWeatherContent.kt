package com.project.weatherapp.screens.DayWeatherScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.weatherapp.R
import com.project.weatherapp.commons.listOfDayOfTheWeekWeatherMock
import com.project.weatherapp.models.WeekWeatherMock.DayOfWeekWeatherMock
import com.project.weatherapp.view_model.WeatherViewModel

@Composable
fun DayWeatherContent(dayId: String, weatherViewModel: WeatherViewModel) {
    val cityName = weatherViewModel.currentCity.value

    val currentDayWeather = if (dayId.toInt() > 10) {
        val currentApiWeather = weatherViewModel.currentCityWeatherDetails.value
        DayOfWeekWeatherMock(
            id = 99,
            dayOfWeek = "TUES",
            temperature = currentApiWeather!!.main.temp.toInt(),
            minTemperature = currentApiWeather.main.tempmin.toInt(),
            maxTemperature = currentApiWeather.main.temp_max.toInt(),
            windPower = currentApiWeather.wind.speed.toString(),
            pressure = currentApiWeather.clouds.all.toString()
        )
    } else {
        listOfDayOfTheWeekWeatherMock[dayId.toInt()]
    }

    val measurementResource = remember { mutableStateOf(R.string.celsius_measurement) }
    val measurement = stringResource(id = measurementResource.value)
    val temperature = currentDayWeather.temperature
    val minTemperatureMock = currentDayWeather.minTemperature
    val maxTemperatureMock = currentDayWeather.maxTemperature
    val pressure = currentDayWeather.pressure
    val wind = currentDayWeather.windPower

    Column(
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
            .padding(horizontal = 60.dp, vertical = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(cityName, fontSize = 25.sp, fontWeight = FontWeight.Bold)
        }
        Text("Sunny", fontSize = 18.sp)
        Image(
            painter = painterResource(id = R.drawable.sunny_weather_icon),
            contentDescription = "icon weather",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(200.dp)
        )
        Text(
            "$temperature $measurement",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .size(100.dp)
                .background(Color.Transparent)
        )

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painterResource(id = R.drawable.low_temperature),
                    contentDescription = "Minimum temperature",
                    modifier = Modifier.size(50.dp)
                )
                Text("$maxTemperatureMock $measurement", fontWeight = FontWeight.Bold)
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("$minTemperatureMock $measurement", fontWeight = FontWeight.Bold)
                Image(
                    painterResource(id = R.drawable.high_temperature),
                    contentDescription = "Minimum temperature",
                    modifier = Modifier.size(50.dp)
                )
            }
        }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painterResource(id = R.drawable.wind_icon),
                    contentDescription = "Wind Power",
                    modifier = Modifier.size(50.dp)
                )
                Text("$wind km/h", fontWeight = FontWeight.Bold)
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("$pressure hPa", fontWeight = FontWeight.Bold)
                Image(
                    painterResource(id = R.drawable.pressure),
                    contentDescription = "Pressure",
                    modifier = Modifier.size(50.dp)
                )
            }
        }
    }
}
