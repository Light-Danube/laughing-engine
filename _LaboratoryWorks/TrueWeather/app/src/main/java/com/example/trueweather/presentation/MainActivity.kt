package com.example.trueweather.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.example.trueweather.R
import com.example.trueweather.data.remote.model.ThroneHero

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find nav host fragment
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        // Get nav controller
        val navController = navHostFragment.navController
    }
}