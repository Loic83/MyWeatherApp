package com.example.myweatherapp.ui.city

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myweatherapp.R
import com.example.myweatherapp.domain.model.City
import com.example.myweatherapp.ui.weather.WeatherActivity
import com.example.myweatherapp.ui.weather.WeatherFragment.Companion.EXTRA_CITY_NAME
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CityFragment : Fragment() , CityAdapter.CityItemListener{

    companion object {
        fun newInstance() = CityFragment()
    }

    interface CityFragmentListener {
        fun onCitySelected(city: City)
    }

    var listener: CityFragmentListener? = null

    private lateinit var cities: MutableList<City>
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CityAdapter
    private lateinit var viewModel: CityViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        cities = mutableListOf()
        adapter = CityAdapter(cities, this)

        val view = inflater.inflate(R.layout.fragment_city, container, false)
        recyclerView = view.findViewById(R.id.cities_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = adapter
        viewModel = ViewModelProvider(this)[CityViewModel::class.java]
        updateViewModelCities()
    }

    override fun onCitySelected(city: City) {
        if (checkForInternet(context)) {
            val intent = Intent(context, WeatherActivity::class.java)
            intent.putExtra(EXTRA_CITY_NAME,""+city.name)
            context?.startActivity(intent)
        } else {
            Toast.makeText(context, getString(R.string.no_connection), Toast.LENGTH_SHORT).show()
        }

    }

    private fun updateViewModelCities() {
        lifecycleScope.launch {
            viewModel.cities.invoke()
                .observe(viewLifecycleOwner, Observer { newCities -> updateCities(newCities!!) })
        }
    }

    private fun updateCities(newCities: List<City>) {
        cities.clear()
        cities.addAll(newCities)
        adapter.notifyDataSetChanged()
    }

    private fun checkForInternet(context: Context?): Boolean {

        val connectivityManager = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val network = connectivityManager.activeNetwork ?: return false

        val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false

        return when {
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true

            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true

            else -> false
        }
    }

}