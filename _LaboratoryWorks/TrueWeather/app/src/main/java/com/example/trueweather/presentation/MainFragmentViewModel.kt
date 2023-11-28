package com.example.trueweather.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trueweather.data.ThroneRepository
import com.example.trueweather.data.remote.model.ThroneHero
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainFragmentViewModel(private val repository: ThroneRepository): ViewModel() {
    val totalCharacters = MutableLiveData<Int>()

    fun loadCharacters() {
        viewModelScope.launch {
            val characters = repository.getCharacters().value
            totalCharacters.value = characters?.size ?: 0
        }
    }

    suspend fun getCharacter(id: Int): LiveData<ThroneHero>? {
        return viewModelScope.async {
            repository.getCharacter(id)
        }.await()
    }

    private val _selectedCharacter = MutableLiveData<ThroneHero?>()
    suspend fun getCharacterById(id: Int) {
        val character = repository.getCharacter(id)?.value
        _selectedCharacter.value = character
    }
}