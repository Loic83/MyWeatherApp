package com.example.myweatherapp.ui.city

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.myweatherapp.R
import com.example.myweatherapp.domain.model.City
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.lang.Math.random
import java.util.*

@AndroidEntryPoint
class AddCityFragment : Fragment() {

    private lateinit var viewModel: CityViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_city, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnValidate = getView()?.findViewById<Button>(R.id.button_validate)
        val editText = getView()?.findViewById<EditText>(R.id.edit_choose_name)

        viewModel = ViewModelProvider(this).get(CityViewModel::class.java)

        btnValidate?.setOnClickListener {
            if (!editText?.text.toString().isBlank()) {
                val job = lifecycleScope.launch {
                    val random = Random()
                    viewModel.insertCity(City(random.nextInt(1000).toLong(),editText?.text.toString()))
                }

                if(job.isCompleted) {
                    activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.root_container,CityFragment())
                    ?.commit()
                }

            }
        }
    }
}