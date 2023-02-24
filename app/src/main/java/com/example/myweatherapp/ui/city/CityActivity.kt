package com.example.myweatherapp.ui.city

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myweatherapp.R

class CityActivity : AppCompatActivity() {

    private lateinit var cityFragment: CityFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city)
    }
}