package com.example.myweatherapp.domain.repository

import androidx.lifecycle.LiveData
import com.example.myweatherapp.domain.model.City

interface CityRepository {

    suspend fun getCities() : LiveData<List<City>>

    suspend fun insertCity(city: City)

    suspend fun deleteCity(id: Long)

}