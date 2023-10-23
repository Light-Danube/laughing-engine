package com.example.hellokittyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

@Suppress("DEPRECATION")
class KittyData : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kitty_data)

        val returnButton = findViewById<Button>(R.id.returnButton)
        val animalImage = findViewById<ImageView>(R.id.catDataImg)
        val animalName = findViewById<TextView>(R.id.catDataName)
        val animalDescription = findViewById<TextView>(R.id.catDataDesc)

        val animal = intent.getParcelableExtra<Animal>("animal")

        // Check if the data is not null
        if (animal != null) {
            // Display the data in the second activity
            animalName.text = animal.name
            animalDescription.text = animal.description
            animalImage.setImageResource(animal.imageID)
        }

        returnButton.setOnClickListener{
            openActivity()
        }
    }

    private fun openActivity() {
        val acc = Intent(this, MainActivity::class.java)
        startActivity(acc)
    }
}