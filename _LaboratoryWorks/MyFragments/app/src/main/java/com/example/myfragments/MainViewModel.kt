package com.example.myfragments

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // Movie data
    val movies = listOf(
        Movie("The Matrix", "matrix.jpg", "Sci-fi action movie..."),
        Movie("Inception", "inception.jpg", "Dream heist movie..."),
        Movie("Inception 2", "inception.jpg", "Dream heist movie..."),
        Movie("Inception 3", "inception.jpg", "Dream heist movie..."))
}