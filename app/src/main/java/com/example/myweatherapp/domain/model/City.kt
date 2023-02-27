package com.example.myweatherapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class City(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var name: String)