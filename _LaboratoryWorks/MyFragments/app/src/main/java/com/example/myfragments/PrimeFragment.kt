package com.example.myfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PrimeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: MainViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val movies = listOf(
            Movie("The Matrix", "matrix.jpg", "Sci-fi action film..."),
            Movie("Inception", "inception.jpg", "Mind-bending thriller..."),
            Movie("Yoton Yo", "yotonyo.jpg", "Art-house story...")
        )

        val adapter = MoviesAdapter(movies) { _ ->
            // Navigate to detail
        }

        recyclerView.adapter = adapter
    }

}