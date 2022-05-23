package com.project.weatherapp.Screens.DayWeatherScreen

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.weatherapp.R
import com.project.weatherapp.commons.CityEditableText

@Composable
fun DayWeatherContent() {

    val measurementResource = remember { mutableStateOf(R.string.celsius_measurement) }
    val measurement = stringResource(id = measurementResource.value)
    val minTemperatureMock = 13
    val maxTemperatureMock = 22
    val pressure = 300
    val wind = 23

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
            CityEditableText()
        }
        Text("Sunny", fontSize = 18.sp)
        Image(
            painter = painterResource(id = R.drawable.sunny_weather_icon),
            contentDescription = "icon weather",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(200.dp)
        )
        Text(
            "3 $measurement",
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
                Text("$wind BAR", fontWeight = FontWeight.Bold)
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("$pressure ALF", fontWeight = FontWeight.Bold)
                Image(
                    painterResource(id = R.drawable.pressure),
                    contentDescription = "Pressure",
                    modifier = Modifier.size(50.dp)
                )
            }
        }
    }
}


@Preview
@Composable
private fun previewDayWeatherContent() {
    DayWeatherContent()
}