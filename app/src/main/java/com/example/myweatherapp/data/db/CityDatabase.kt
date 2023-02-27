package com.example.myweatherapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myweatherapp.domain.model.City

@Database(
    entities = [City::class],
    version = 1
)
abstract class CityDatabase: RoomDatabase() {

    abstract val cityDao: CityDao

    companion object {
        const val DATABASE_NAME = "cities_db"
    }
}