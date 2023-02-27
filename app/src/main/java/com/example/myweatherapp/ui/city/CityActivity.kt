package com.example.myweatherapp.ui.city

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.example.myweatherapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CityActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city)

        val cityFragment = CityFragment()

        supportFragmentManager.beginTransaction()
            .replace(R.id.root_container, cityFragment)
            .commitAllowingStateLoss()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.activity_city, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.action_create_city -> {

                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.root_container, AddCityFragment())
                transaction.commit()

                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }
}