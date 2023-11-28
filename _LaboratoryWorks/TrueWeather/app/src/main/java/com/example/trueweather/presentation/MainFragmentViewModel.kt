package com.example.trueweather.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.trueweather.data.ThroneRepository
import kotlinx.coroutines.coroutineScope

class MainFragmentViewModel(private val repository: ThroneRepository): ViewModel() {
    val id: MutableLiveData<Int?> = MutableLiveData(null)

    suspend fun loadIdFromApi() = coroutineScope {
        // Use repository.getCharacters() to retrieve all characters from the API
        val characters = repository.getCharacters().await()

        // Extract the first ID from the list of characters
        val id = characters.firstOrNull()?.id

        // Update the LiveData with the extracted ID
        id?.let { this.id.postValue(it) }
    }
}