package com.example.myweatherapp.ui.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myweatherapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.beginTransaction()
            .replace(android.R.id.content, WeatherFragment.newInstance())
            .commit()
    }
}