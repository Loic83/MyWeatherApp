package com.example.myweatherapp.data.repository

import com.example.api.mappers.Mappers
import com.example.api.service.OpenWeatherService
import com.example.api.model.Weather
import com.example.myweatherapp.domain.repository.WeatherRepository

class WeatherRepositoryImpl ( private val apiService : OpenWeatherService) : WeatherRepository {
    override suspend fun getWeather(nameCity: String) : Weather {
        val response = apiService.getWeather(nameCity)

        var weather = Weather("",0.0f,0,0,"")

        if (response.isSuccessful) {
            weather = Mappers.mapOpenWeatherDataToWeather(response.body()!!)
        }

        return weather
    }


}