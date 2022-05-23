package data_source

import com.project.weatherapp.models.CurrentWeather.CurrentWeather
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface WeatherDataSource {
    @Headers(
        "X-RapidAPI-Key: e8da9bbf44msh08e147f2f09974cp19012cjsnc53b44009145",
        "X-RapidAPI-Host: community-open-weather-map.p.rapidapi.com"
    )
    @GET("/weather")
    suspend fun getCurrentWeather(
        @Query("q") location: String,
        @Query("units") measurement: String
    ): Response<CurrentWeather>
}