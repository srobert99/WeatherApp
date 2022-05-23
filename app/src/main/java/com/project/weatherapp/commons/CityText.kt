package com.project.weatherapp.commons

import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun CityEditableText(
    modifier: Modifier = Modifier,
    currentText: String,
    onTextChange: (String) -> Unit,
    onFocusChanged: () -> Unit
) {
    BasicTextField(
        value = currentText,
        onValueChange = { onTextChange(it) },
        singleLine = true,
        modifier = modifier.onFocusChanged {
            if (!it.isFocused) {
                onFocusChanged()
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
