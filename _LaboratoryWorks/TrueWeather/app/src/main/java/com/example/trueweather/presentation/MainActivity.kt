package com.example.trueweather.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import com.example.trueweather.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize Navigation
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)

        // Set default destination
        navController.navigate(R.id.fragment_hero)
    }
}