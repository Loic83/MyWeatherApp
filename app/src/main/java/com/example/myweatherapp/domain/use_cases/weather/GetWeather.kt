package com.example.myweatherapp.domain.use_cases.weather

import com.example.api.model.Weather
import com.example.myweatherapp.domain.repository.WeatherRepository


class GetWeather(private val repository: WeatherRepository) {

    suspend operator fun invoke(cityName : String) : Weather {
        return repository.getWeather(cityName)
    }

}