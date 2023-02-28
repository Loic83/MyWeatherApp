package com.example.api

import com.example.api.service.OpenWeatherService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class OpenWeatherApi {

    private val BASE_URL: String = "https://api.openweathermap.org/data/2.5/"

    val openWeatherService: OpenWeatherService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        openWeatherService = retrofit.create(OpenWeatherService::class.java)
    }

}