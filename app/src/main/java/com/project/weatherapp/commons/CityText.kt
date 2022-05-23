package com.project.weatherapp.commons

import android.widget.Toast
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun CityEditableText(
    modifier: Modifier = Modifier,
    notInit: Boolean = false,
    enabled: Boolean = false
) {
    val text = remember { mutableStateOf("SIBIU") }
    val context = LocalContext.current

    BasicTextField(
        value = text.value,
        onValueChange = { text.value = it.uppercase() },
        singleLine = true,
        enabled = enabled,
        modifier = modifier.onFocusChanged {
            if (!it.isFocused && !notInit) {
                Toast.makeText(context, "merge", Toast.LENGTH_SHORT).show()
            }
        },
        textStyle = CityFieldTextStyle,
    )
}

private val CityFieldTextStyle = TextStyle(
    fontWeight = FontWeight.Bold,
    fontSize = 25.sp,
    textAlign = TextAlign.Center
)
