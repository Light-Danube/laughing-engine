package com.example.hellokittyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class KittyData : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kitty_data)

        val returnButton = findViewById<Button>(R.id.returnButton)

        //val animalData = intent.getParcelableExtra<Animal>("Animal")

        returnButton.setOnClickListener{
            openActivity()
        }
    }

    private fun openActivity() {
        val intent = Intent(this, MainActivity::class.java)
        //intent.getParcelableExtra<Animal>("Animal")
        startActivity(intent)
    }
}