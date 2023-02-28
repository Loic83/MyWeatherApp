package com.example.api.mappers

import com.example.api.model.Weather
import com.example.api.model.WeatherWrapper

object Mappers {
    fun mapOpenWeatherDataToWeather(weatherWrapper: WeatherWrapper) : Weather {
        val weather = weatherWrapper.weather.first()
        return Weather(
            description = weather.description,
            temperature = weatherWrapper.main.temp,
            humidity = weatherWrapper.main.humidity,
            pressure = weatherWrapper.main.pressure,
            icon = weather.icon
        )
    }
}