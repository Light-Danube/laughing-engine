package com.example.hellokittyapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import android.widget.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.hellokittyapp.ui.theme.HelloKittyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            setContentView(R.layout.activity_main)
        }

        val detailsButton = findViewById<Button>(R.id.animalDetails1)

        detailsButton.setOnClickListener {
            // Define what happens when the button is clicked.
            // For example, start a new activity.
            println("Test")
        }
    }
}