package com.example.myfragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    // LiveData to hold list of movies
    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> = _movies

    init {
        // Load list of movies
        _movies.value = listOf(
            Movie("The Matrix", "matrix.jpg", "Sci-fi action film..."),
            Movie("Inception", "inception.jpg", "Mind-bending thriller..."),
            Movie("Yoton Yo", "yotonyo.jpg", "Art-house story...")
        )
    }
}