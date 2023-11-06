package com.example.myfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find nav host fragment
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_graph)
                as NavHostFragment

        // Get nav controller
        val navController = navHostFragment.navController
    }
}