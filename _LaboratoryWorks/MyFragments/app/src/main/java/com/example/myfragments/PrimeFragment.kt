package com.example.myfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
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

        val adapter = MoviesAdapter(movies) { selectedMovie ->
            // Handle item click here, e.g., navigate to detail screen
            // You can use 'selectedMovie' to access the clicked movie

            // Get the NavController
            val navController = Navigation.findNavController(requireView())

            // Create a bundle to pass data to SecundaFragment (if needed)
            val bundle = bundleOf("movie" to selectedMovie)

            // Navigate to SecundaFragment with the provided bundle
            navController.navigate(R.id.showMovieDetail, bundle)
        }


        recyclerView.adapter = adapter
    }

}