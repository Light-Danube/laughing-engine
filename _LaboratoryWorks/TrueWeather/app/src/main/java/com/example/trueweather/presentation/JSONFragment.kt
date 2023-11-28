package com.example.trueweather.presentation

import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.trueweather.R
import com.example.trueweather.data.remote.model.ThroneHero


@Suppress("DEPRECATION")
class JSONFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_secunda, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val character = arguments?.getParcelable<Parcelable>("character") as? ThroneHero

        // Assuming you have a TextView with ID "jsonTextView" in your layout
        val jsonTextView = view.findViewById<TextView>(R.id.jsonAppText)
        jsonTextView.text = character?.toString() ?: "Character not found"
    }
}