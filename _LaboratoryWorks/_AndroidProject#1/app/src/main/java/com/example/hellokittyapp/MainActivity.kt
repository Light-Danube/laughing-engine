package com.example.hellokittyapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.hellokittyapp.ui.theme.HelloKittyAppTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*val detailsButton = findViewById<Button>(R.id.animalDetails1)

        detailsButton.setOnClickListener {
            // Define what happens when the button is clicked.
            // For example, start a new activity.
            println("Test")
        }*/
    }
}