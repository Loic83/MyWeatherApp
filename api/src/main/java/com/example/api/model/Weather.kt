package com.example.api.model

data class Weather(val description: String,
                   val temperature: Float,
                   val humidity: Int,
                   val pressure: Int,
                   val icon: String)
