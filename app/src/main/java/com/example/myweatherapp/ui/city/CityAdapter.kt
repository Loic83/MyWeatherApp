package com.example.myweatherapp.ui.city

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.myweatherapp.R
import com.example.myweatherapp.domain.model.City

class CityAdapter(private val cities: List<City>,
                  private val cityListener: CityItemListener
)
    : RecyclerView.Adapter<CityAdapter.ViewHolder>(), View.OnClickListener {

    interface CityItemListener {
        fun onCitySelected(city: City)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView = itemView.findViewById<CardView>(R.id.card_view)!!
        val cityNameView = itemView.findViewById<TextView>(R.id.name)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewItem = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_city, parent, false)
        return ViewHolder(viewItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val city = cities[position]
        with(holder) {
            cardView.setOnClickListener(this@CityAdapter)
            cardView.tag = city
            cityNameView.text = city.name
        }
    }

    override fun getItemCount(): Int = cities.size

    override fun onClick(v: View) {
        when (v.id) {
            R.id.card_view -> cityListener.onCitySelected(v.tag as City)
        }
    }
}