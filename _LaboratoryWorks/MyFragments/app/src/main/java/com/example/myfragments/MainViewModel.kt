package com.example.myfragments

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // Movie data
    val movies = listOf(
        Movie("The Matrix", "matrix.jpg", "Scifi action movie..."),
        Movie("Inception", "inception.jpg", "Dream heist movie..."),
        Movie("Inception", "inception.jpg", "Dream heist movie..."),
        Movie("Inception", "inception.jpg", "Dream heist movie..."))
}