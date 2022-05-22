package com.project.weatherapp.Screens.MainScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.weatherapp.R


@Composable
fun MainScreenContent() {
    val measurement = stringResource(id = R.string.celsius_measurement)
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
            Text("SIBIU", fontSize = 40.sp, fontWeight = FontWeight.Bold)
            Text("Sunny", fontSize = 18.sp)
            Image(
                painter = painterResource(id = R.drawable.sunny_weather_icon),
                contentDescription = "icon weather",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(200.dp)
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("3 $measurement", fontSize = 30.sp, fontWeight = FontWeight.Bold)
            }
        }
        MainScreenBottomBar(modifier = Modifier.align(Alignment.BottomCenter))
    }
}


@Composable
@Preview
private fun PreviewMainScreen() {
    MainScreenContent()
}
