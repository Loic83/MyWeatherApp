package com.example.myweatherapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myweatherapp.domain.model.City

@Dao
interface CityDao {

    @Query("SELECT * FROM City")
    fun getCities(): LiveData<List<City>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCity(city: City)

}