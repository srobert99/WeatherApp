package com.project.weatherapp.Screens.MainScreen

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
import com.project.weatherapp.R

@Composable
fun MainScreenBottomBar(
    modifier: Modifier = Modifier,
    @StringRes measurementResource: Int = R.string.celsius_measurement
) {
    MainScreenBottomBarContent(modifier, measurementResource)
}

@Composable
private fun MainScreenBottomBarContent(modifier: Modifier, @StringRes measurementResource: Int) {
    val list = listOf("a", "b", "c", "d", "e", "f", "g")
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 5.dp)
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        for (item in list) {
            MainScreenBottomBarItem(measurementResource = measurementResource)
        }
    }
}


@Composable
private fun MainScreenBottomBarItem(@StringRes measurementResource: Int = R.string.celsius_measurement) {
    val measurement = stringResource(id = measurementResource)
    Card(
        backgroundColor = Color.Transparent,
        elevation = 0.dp,
        border = BorderStroke(2.dp, color = Color.White),
        modifier = Modifier.clickable {  }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(10.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.sunny_weather_icon),
                modifier = Modifier.size(80.dp),
                contentDescription = "weather icon"
            )
            Row() {
                Text("13$measurement", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}