package data_source

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance() {

    val weatherApi: WeatherDataSource by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherDataSource::class.java)
    }

    companion object {
        private const val baseUrl = "https://community-open-weather-map.p.rapidapi.com"
    }
}


