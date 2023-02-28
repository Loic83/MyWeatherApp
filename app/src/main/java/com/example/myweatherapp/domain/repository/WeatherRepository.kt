package com.example.myweatherapp.domain.repository

import com.example.api.model.Weather

interface WeatherRepository {

    suspend fun getWeather(nameCity : String) : Weather

}