package com.example.trueweather.presentation

import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.trueweather.R
import com.example.trueweather.data.remote.model.ThroneHero

@Suppress("DEPRECATION")
class WeatherFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hero, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val character = arguments?.getParcelable<Parcelable>("character") as? ThroneHero

        // Let find out our data for our form:
        val charPortraitImg = view.findViewById<ImageView>(R.id.charPortrait)
        val heroNameText = view.findViewById<TextView>(R.id.heroName)
        val idNameText = view.findViewById<TextView>(R.id.idName)
        val firstNameText = view.findViewById<TextView>(R.id.firstName)
        val lastNameText = view.findViewById<TextView>(R.id.lastName)
        val fullNameText = view.findViewById<TextView>(R.id.fullName)
        val titleNameText = view.findViewById<TextView>(R.id.titleName)
        val familyNameText = view.findViewById<TextView>(R.id.familyName)
        val imageNameText = view.findViewById<TextView>(R.id.imageName)
        val imageURLNameText = view.findViewById<TextView>(R.id.imageURLName)

        heroNameText.text = character?.fullName ?: "Character not found"
        idNameText.text = "ID:" + " " + (character?.id ?: "Character not found").toString()
        firstNameText.text = "First Name:" + " " + character?.firstName ?: "Character not found"
        lastNameText.text = "Last Name:" + " " + character?.lastName ?: "Character not found"
        fullNameText.text = "Full Name:" + " " + character?.fullName ?: "Character not found"
        titleNameText.text = "Title:" + " " + character?.title ?: "Character not found"
        familyNameText.text = "Family:" + " " + character?.family ?: "Character not found"
        imageNameText.text = "Image:" + " " + character?.image ?: "Character not found"
        imageURLNameText.text = "Image URL:" + " " + character?.imgURL ?: "Character not found"

        // Load the image using Glide
        character?.imgURL?.let { url ->
            Glide.with(this)
                .load(url)
                .into(charPortraitImg)
        }


        val returnButton = view.findViewById<Button>(R.id.returnBtn)
        returnButton.setOnClickListener {
            // Use the Navigation Component to navigate back to the first fragment
            findNavController().navigate(R.id.fragment_prime)
        }
    }
}