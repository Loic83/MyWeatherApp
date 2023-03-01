package com.example.myweatherapp.domain.repository

import com.example.myweatherapp.data.model.Weather

interface WeatherRepository {

    suspend fun getWeather(nameCity : String) : Weather

}