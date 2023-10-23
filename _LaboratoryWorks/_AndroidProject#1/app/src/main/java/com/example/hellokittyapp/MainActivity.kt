package com.example.hellokittyapp

import android.os.Bundle
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val detailsButton1 = findViewById<Button>(R.id.animalDetails1)
        val detailsButton2 = findViewById<Button>(R.id.animalDetails2)
        val detailsButton3 = findViewById<Button>(R.id.animalDetails3)

        val animal1 = Animal("Kitty", "This cat number 1", R.id.animalImg1)
        val animal2 = Animal("Clawy", "This cat number 2", R.id.animaImg2)
        val animal3 = Animal("Bitty", "This cat number 3", R.id.animalImg3)

        detailsButton1.setOnClickListener {
            openSecondActivity(animal1)
        }

        detailsButton2.setOnClickListener {
            openSecondActivity(animal2)
        }

        detailsButton3.setOnClickListener {
            openSecondActivity(animal3)
        }
    }

    private fun openSecondActivity(data: Animal) {
        val intent = Intent(this, KittyData::class.java)
        //intent.getParcelableExtra<Animal>("Animal")
        startActivity(intent)
    }
}