package com.example.myweatherapp.domain.model

data class Weather(val description: String,
                   val temperature: Float,
                   val humidity: Int,
                   val pressure: Int,
                   val icon: String)
