package com.example.trueweather.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

    private fun navigateToJSONFragment(character: ThroneHero?) {
        val jsonFragment = JSONFragment()
        val bundle = Bundle().apply {
            putParcelable("character", character)
        }
        jsonFragment.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_secunda, jsonFragment)
            .addToBackStack(null)
            .commit()
    }

}