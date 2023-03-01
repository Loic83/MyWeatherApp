package com.example.myweatherapp.data.mappers

import com.example.api.model.MainDataDTO
import com.example.api.model.WeatherDataDTO
import com.example.api.model.WeatherWrapperDTO
import com.example.myweatherapp.data.model.MainData
import com.example.myweatherapp.data.model.Weather
import com.example.myweatherapp.data.model.WeatherData
import com.example.myweatherapp.data.model.WeatherWrapper

object Mappers {
    fun mapWeatherDataToWeather(weatherWrapper: WeatherWrapper) : Weather {
        val weather = weatherWrapper.weather.first()
        return Weather(
            description = weather.description,
            temperature = weatherWrapper.main.temp,
            humidity = weatherWrapper.main.humidity,
            pressure = weatherWrapper.main.pressure,
            icon = weather.icon
        )
    }

    fun weatherWrapperDTOToWeatherWrapper(weatherWrapperDTO: WeatherWrapperDTO) : WeatherWrapper =
        WeatherWrapper(listWeatherDataDTOToListWeatherData(weatherWrapperDTO.weather),
            mainDataDTOToMainData(weatherWrapperDTO.main))

    private fun listWeatherDataDTOToListWeatherData(arrayDTO: List<WeatherDataDTO>) : List<WeatherData> =
        arrayDTO.map { weatherDataDTOToWeatherData(it) }


    private fun weatherDataDTOToWeatherData(weatherDataDTO : WeatherDataDTO) : WeatherData =
        WeatherData(weatherDataDTO.description, weatherDataDTO.icon)


    private fun mainDataDTOToMainData(mainDataDTO : MainDataDTO) : MainData =
        MainData(mainDataDTO.temp, mainDataDTO.pressure, mainDataDTO.humidity)

}