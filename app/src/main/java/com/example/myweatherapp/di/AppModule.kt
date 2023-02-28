package com.example.myweatherapp.di

import android.app.Application
import androidx.room.Room
import com.example.api.service.OpenWeatherService
import com.example.myweatherapp.data.db.CityDatabase
import com.example.myweatherapp.data.repository.CityRepositoryImpl
import com.example.myweatherapp.data.repository.WeatherRepositoryImpl
import com.example.myweatherapp.domain.repository.CityRepository
import com.example.myweatherapp.domain.repository.WeatherRepository
import com.example.myweatherapp.domain.use_cases.city.CityUseCases
import com.example.myweatherapp.domain.use_cases.city.GetCities
import com.example.myweatherapp.domain.use_cases.city.InsertCity
import com.example.myweatherapp.domain.use_cases.weather.GetWeather
import com.example.myweatherapp.domain.use_cases.weather.WeatherUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCityDatabase(app: Application): CityDatabase {
        return Room.databaseBuilder(
            app,
            CityDatabase::class.java,
            CityDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideCityRepository(db: CityDatabase): CityRepository {
        return CityRepositoryImpl(db.cityDao)
    }

    @Provides
    @Singleton
    fun provideCityUseCases(repository: CityRepository): CityUseCases {
        return CityUseCases(
            getCities = GetCities(repository),
            insertCity = InsertCity(repository)
        )
    }

    @Provides
    @Singleton
    fun provideWeatherRepository(apiService : OpenWeatherService): WeatherRepository {
        return WeatherRepositoryImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideWeatherUseCase(repository : WeatherRepository) : WeatherUseCases {
        return WeatherUseCases(
            getWeather = GetWeather(repository)
        )
    }

}