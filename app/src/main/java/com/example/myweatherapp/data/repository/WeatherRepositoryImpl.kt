package com.example.myweatherapp.data.repository

import com.example.myweatherapp.data.mappers.Mappers
import com.example.api.service.OpenWeatherService
import com.example.myweatherapp.data.mappers.Mappers.weatherWrapperDTOToWeatherWrapper
import com.example.myweatherapp.data.model.Weather
import com.example.myweatherapp.domain.repository.WeatherRepository

class WeatherRepositoryImpl ( private val apiService : OpenWeatherService) : WeatherRepository {
    override suspend fun getWeather(nameCity: String) : Weather {
        val response = apiService.getWeather(nameCity)

        var weather = Weather("",0.0f,0,0,"")

        if (response.isSuccessful) {
            weather = Mappers.mapWeatherDataToWeather(weatherWrapperDTOToWeatherWrapper(response.body()!!))
        }

        return weather
    }


}