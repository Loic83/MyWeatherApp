package com.example.api.model

data class WeatherWrapper(val weather: Array<WeatherData>,
                          val main: MainData)

class WeatherData(val description: String,
                  val icon: String)


data class MainData(val temp: Float,
                    val pressure: Int,
                    val humidity: Int)
