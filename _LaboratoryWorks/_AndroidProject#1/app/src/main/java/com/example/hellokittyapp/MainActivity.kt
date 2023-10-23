package com.example.hellokittyapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.view.View

import com.example.hellokittyapp.ui.theme.HelloKittyAppTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val detailsButton = findViewById<Button>(R.id.animalDetails1)
    }
}