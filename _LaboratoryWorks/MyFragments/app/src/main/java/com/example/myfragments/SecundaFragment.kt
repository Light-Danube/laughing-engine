package com.example.myfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

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
            // You can access other properties like movie.imageResourceId and movie.description
        }

        return view
    }
}