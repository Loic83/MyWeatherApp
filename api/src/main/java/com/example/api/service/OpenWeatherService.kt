package com.example.api.service

import com.example.api.model.WeatherWrapper
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

private const val API_KEY = "75671d0bd521ee8d0481468b6d291c56"

interface OpenWeatherService {

    @GET("weather?units=metric&lang=fr")
    suspend fun getWeather(@Query("q") cityName: String,
                   @Query("appid") apiKey: String = API_KEY) : Response<WeatherWrapper>

}