package com.example.trueweather.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.trueweather.data.ThroneRepository
import com.example.trueweather.data.remote.model.ThroneHero
import kotlinx.coroutines.coroutineScope

class MainFragmentViewModel(private val repository: ThroneRepository): ViewModel() {
    // Live data for loaded characters
    val characters = MutableLiveData<List<ThroneHero>>()

    // Total number of characters
    var totalCount = 0

    fun loadCharacters() {
        // Get characters from repository
        characters.value = repository.getCharacters()
        totalCount = characters.value!!.size // Update total count
    }
}