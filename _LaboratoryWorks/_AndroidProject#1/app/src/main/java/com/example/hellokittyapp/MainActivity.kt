package com.example.hellokittyapp

import android.app.Dialog
import android.os.Bundle
import android.content.Intent
import android.view.MenuItem
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.PopupMenu
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val detailsButton1 = findViewById<Button>(R.id.animalDetails1)
        val detailsButton2 = findViewById<Button>(R.id.animalDetails2)
        val detailsButton3 = findViewById<Button>(R.id.animalDetails3)

        val animal1 = Animal("Kitty", "This text matches description for Kitty", R.drawable.catimage1)
        val animal2 = Animal("Clawy", "This text matches description for Clawy", R.drawable.catimage2)
        val animal3 = Animal("Bitty", "This text matches description for Bitty", R.drawable.catimage3)

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
        intent.putExtra("Animal", data)
        startActivity(intent)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about_creator -> {
                showAboutCreatorPopup()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun showAboutCreatorPopup() {
        val popupMenu = PopupMenu(this, findViewById(R.id.toolbar))
        popupMenu.menuInflater.inflate(R.menu.menu_main, popupMenu.menu)

        val aboutCreatorItem = popupMenu.menu.findItem(R.id.action_about_creator)
        aboutCreatorItem.setOnMenuItemClickListener {
            /// Create a custom dialog
            val dialog = Dialog(this)
            dialog.setContentView(R.layout.about_creator_dialog)

            // Customize the dialog's appearance (optional)
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            dialog.window?.setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT
            )

            // Find and customize elements in the dialog layout
            val creatorName = dialog.findViewById<TextView>(R.id.creatorName)
            val creatorDescription = dialog.findViewById<TextView>(R.id.creatorDescription)

            creatorName.text = "John Doe" // Replace with the creator's name
            creatorDescription.text = "A passionate app developer and tech enthusiast."

            // Handle the close button click
            val closeButton = dialog.findViewById<Button>(R.id.closeButton)
            closeButton.setOnClickListener {
                dialog.dismiss() // Close the dialog
            }

            dialog.show() // Show the dialog

            true
        }

        popupMenu.show()
    }


}