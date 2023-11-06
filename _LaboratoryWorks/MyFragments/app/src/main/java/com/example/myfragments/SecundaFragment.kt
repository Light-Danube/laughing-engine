package com.example.myfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide

@Suppress("DEPRECATION")
class SecundaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_secunda, container, false)

        // Get movie from arguments
        val movie = arguments?.getParcelable<Movie>("movie")

        // Display movie details (adjust this part as needed)
        if (movie != null) {
            view.findViewById<TextView>(R.id.textView).text = movie.title
            view.findViewById<TextView>(R.id.textView2).text = movie.description

            val imageView1 = view.findViewById<ImageView>(R.id.movieImage)
            val imageView2 = view.findViewById<ImageView>(R.id.movieImageAdd1)
            val imageView3 = view.findViewById<ImageView>(R.id.movieImageAdd2)

            // Load the image using Glide
            Glide.with(this)
                .load(movie.posterUrl)
                .override(300, 300) // Set the desired width and height
                .fitCenter() // Fit the image within the specified dimensions
                .into(imageView1)
            Glide.with(this)
                .load(movie.posterUrl)
                .override(150, 150) // Set the desired width and height
                .fitCenter() // Fit the image within the specified dimensions
                .into(imageView2)
            Glide.with(this)
                .load(movie.posterUrl)
                .override(150, 150) // Set the desired width and height
                .fitCenter() // Fit the image within the specified dimensions
                .into(imageView3)
        }

        val returnButton = view.findViewById<Button>(R.id.returnButton)
        returnButton.setOnClickListener {
            // Use the Navigation Component to navigate back to the first fragment
            findNavController().navigateUp()
        }

        return view
    }
}