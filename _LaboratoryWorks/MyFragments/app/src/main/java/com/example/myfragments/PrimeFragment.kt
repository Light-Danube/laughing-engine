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

        val adapter = MoviesAdapter(listOf(Movie(), Movie())) { _ ->
            // Navigate to detail
        }

        recyclerView.adapter = adapter
    }

}