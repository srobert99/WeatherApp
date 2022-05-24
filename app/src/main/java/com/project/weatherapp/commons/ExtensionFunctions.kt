package com.project.weatherapp.commons

fun Int.celsiusToFehrenheit(isFehrenheitMeasurementEnabled:Boolean): Int {
    return if(isFehrenheitMeasurementEnabled){
        (this * (9 / 5) + 32)
    }else{
        this
    }
}

fun String.capitalizeWords(): String =
    split(" ").joinToString(" ") {
        it.replaceFirstChar { char ->
            char.uppercase()
        }
    }