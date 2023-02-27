package com.example.myweatherapp.di

import android.app.Application
import androidx.room.Room
import com.example.myweatherapp.data.db.CityDatabase
import com.example.myweatherapp.data.repository.CityRepositoryImpl
import com.example.myweatherapp.domain.repository.CityRepository
import com.example.myweatherapp.domain.use_cases.city.CityUseCases
import com.example.myweatherapp.domain.use_cases.city.DeleteCity
import com.example.myweatherapp.domain.use_cases.city.GetCities
import com.example.myweatherapp.domain.use_cases.city.InsertCity
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
    fun provideResultUseCases(repository: CityRepository): CityUseCases {
        return CityUseCases(
            getCities = GetCities(repository),
            insertCity = InsertCity(repository),
            deleteCity = DeleteCity(repository)
        )
    }

}