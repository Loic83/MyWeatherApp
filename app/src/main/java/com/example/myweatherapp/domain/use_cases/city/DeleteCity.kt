package com.example.myweatherapp.domain.use_cases.city

import com.example.myweatherapp.domain.model.City
import com.example.myweatherapp.domain.repository.CityRepository

class DeleteCity (private val repository: CityRepository) {

    suspend operator fun invoke(id: Long) {
        return repository.deleteCity(id)
    }

}