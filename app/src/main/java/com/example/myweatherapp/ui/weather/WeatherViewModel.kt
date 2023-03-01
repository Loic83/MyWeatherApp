package com.example.myweatherapp.ui.weather

import androidx.lifecycle.ViewModel
import com.example.api.model.Weather
import com.example.myweatherapp.domain.use_cases.weather.GetWeather
import com.example.myweatherapp.domain.use_cases.weather.WeatherUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor
    (private val weatherUseCases: WeatherUseCases) : ViewModel() {

    val weather : GetWeather = weatherUseCases.getWeather

    fun checkWeatherisEmpty (weather : Weather) : Boolean {
        return !(weather.description.isBlank() && weather.humidity == 0 &&
                weather.pressure == 0 && weather.temperature == 0.0f &&
                weather.icon.isBlank() )
    }

}