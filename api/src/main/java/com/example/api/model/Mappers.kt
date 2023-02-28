package com.example.api.model

import com.example.myweatherapp.domain.model.Weather

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