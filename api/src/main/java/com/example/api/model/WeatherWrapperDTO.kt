package com.example.api.model

data class WeatherWrapperDTO(val weather: List<WeatherDataDTO>,
                          val main: MainDataDTO)