package com.example.myweatherapp.ui.city

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myweatherapp.domain.model.City
import com.example.myweatherapp.domain.use_cases.city.CityUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CityViewModel @Inject constructor(
    private val cityUseCases: CityUseCases
) : ViewModel() {

    val cities = cityUseCases.getCities

    fun deleteCity (id : Long) {
        viewModelScope.launch {
            cityUseCases.deleteCity(id)
        }
    }

    fun insertCity (city : City) {
        viewModelScope.launch {
            cityUseCases.insertCity(city)
        }
    }



}