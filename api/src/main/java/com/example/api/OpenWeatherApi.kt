package com.example.api

import com.example.api.service.OpenWeatherService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class OpenWeatherApi {

    private val BASE_URL: String = "https://api.openweathermap.org/data/2.5/weather?units=metric&lang=fr"

    private val openWeatherService: OpenWeatherService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        openWeatherService = retrofit.create(OpenWeatherService::class.java)
    }

    /*private val gson : Gson by lazy {
        GsonBuilder().setLenient().create()
    }

    private val httpClient : OkHttpClient by lazy {
        OkHttpClient.Builder().build()
    }

    private val retrofit : Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    val openWeatherService : OpenWeatherService by lazy {
        retrofit.create(OpenWeatherService::class.java)
    }*/

}