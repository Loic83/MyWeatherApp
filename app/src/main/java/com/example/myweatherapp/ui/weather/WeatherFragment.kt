package com.example.myweatherapp.ui.weather

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.example.myweatherapp.R
import com.example.api.model.Weather
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class WeatherFragment : Fragment() {

    companion object {
        val EXTRA_CITY_NAME = "com.example.myweatherapp.ui.weather.EXTRA_CITY_NAME"

        fun newInstance() = WeatherFragment()
    }

    private lateinit var viewModel: WeatherViewModel

    private lateinit var city: TextView
    private lateinit var weatherIcon: ImageView
    private lateinit var weatherDescription: TextView
    private lateinit var temperature: TextView
    private lateinit var humidity: TextView
    private lateinit var pressure: TextView

    private lateinit var cityName: String

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_weather, container, false)

        city = view.findViewById(R.id.city)
        weatherIcon = view.findViewById(R.id.weather_icon)
        weatherDescription = view.findViewById(R.id.weather_description)
        temperature = view.findViewById(R.id.temperature)
        humidity = view.findViewById(R.id.humidity)
        pressure = view.findViewById(R.id.pressure)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity?.intent!!.hasExtra(EXTRA_CITY_NAME)) {
            cityName = activity?.intent!!.getStringExtra(EXTRA_CITY_NAME).toString()
        }

        viewModel = ViewModelProvider(this)[WeatherViewModel::class.java]

        lifecycleScope.launch {
            if (cityName != null) {
                showDetailWeather(viewModel.weather.invoke(cityName))
            }
        }

    }

    private fun showDetailWeather(weather : Weather) {
        city.text = cityName
        weatherDescription.text = weather.description
        temperature.text = weather.temperature.toString()
        humidity.text = weather.humidity.toString()
        pressure.text = weather.pressure.toString()
        weatherIcon.background = context?.let { ContextCompat.getDrawable(it,resources.getIdentifier("ic_"+weather.icon.toString(), "drawable", context?.getPackageName())) }
    }

}