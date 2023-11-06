package com.example.myfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class SecundaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_secunda, container, false)

        // Get movie from arguments
        val movie = SecundaFragmentArgs.fromBundle(requireArguments()).movie

        // Display movie details
        view.findViewById<TextView>(R.id.textView).text = movie.title

        return view
    }
}