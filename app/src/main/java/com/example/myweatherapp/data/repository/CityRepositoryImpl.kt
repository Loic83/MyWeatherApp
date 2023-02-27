package com.example.myweatherapp.data.repository

import androidx.lifecycle.LiveData
import com.example.myweatherapp.data.db.CityDao
import com.example.myweatherapp.domain.repository.CityRepository
import com.example.myweatherapp.domain.model.City

class CityRepositoryImpl (
    private val dao: CityDao
 ) : CityRepository {

    override suspend fun getCities(): LiveData<List<City>> {
        return dao.getCities()
    }

    override suspend fun insertCity(city: City) {
        return dao.insertCity(city)
    }

    override suspend fun deleteCity(id: Long) {
        return dao.deleteCity(id)
    }

}