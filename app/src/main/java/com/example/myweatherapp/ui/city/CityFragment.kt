package com.example.myweatherapp.ui.city

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myweatherapp.R
import com.example.myweatherapp.domain.model.City
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
        viewModel = ViewModelProvider(this).get(CityViewModel::class.java)
        updateViewModelCities()
    }

    override fun onCitySelected(city: City) {
        TODO("Not yet implemented")
    }

    override fun onCityDeleted(city: City) {
        TODO("Not yet implemented")
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

}