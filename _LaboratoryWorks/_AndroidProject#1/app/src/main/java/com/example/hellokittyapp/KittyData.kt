package com.example.hellokittyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class KittyData : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kitty_data)

        val returnButton = findViewById<Button>(R.id.returnButton)
        val animalImage = findViewById<ImageView>(R.id.cataDataImg)
        val animalName = findViewById<TextView>(R.id.catDataName)
        val animalDescription = findViewById<TextView>(R.id.cataDataDesc)

        returnButton.setOnClickListener{
            openActivity()
        }

        val receivedAnimal = intent.getSerializableExtra("animal") as Animal

        // Check if the data is not null
        if (receivedAnimal != null) {
            // Display the data in the second activity
            animalName.text = receivedAnimal.name
            animalDescription.text = receivedAnimal.description
            animalImage.setImageResource(receivedAnimal.imageID)
        }


    }

    private fun openActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}