package com.example.myweatherapp.domain.use_cases.city

import androidx.lifecycle.LiveData
import com.example.myweatherapp.domain.model.City
import com.example.myweatherapp.domain.repository.CityRepository

class GetCities (private val repository: CityRepository) {

    suspend operator fun invoke() : LiveData<List<City>> {
        return repository.getCities()
    }

}