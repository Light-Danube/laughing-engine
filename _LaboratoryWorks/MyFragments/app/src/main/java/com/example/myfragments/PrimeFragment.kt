package com.example.myfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PrimeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_prime, container, false)

        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        val movies = arrayListOf<Movie>(
            Movie("The Matrix", "matrix.jpg", "Description"),
            // other movies
        )

        /*val adapter = MoviesAdapter(movies) { movie ->
            // Navigate to detail fragment
            //val action = PrimeFragmentDirections.showMovieDetail(movie)
            //findNavController().navigate(action)
        }*/

        //recyclerView.adapter = adapter

        return view
    }

    /*override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView.adapter = adapter
    }*/

}