package com.example.myweatherapp.data.model

data class Weather(val description: String,
                   val temperature: Float,
                   val humidity: Int,
                   val pressure: Int,
                   val icon: String)
