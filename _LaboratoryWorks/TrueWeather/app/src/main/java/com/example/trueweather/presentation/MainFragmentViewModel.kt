package com.example.trueweather.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.trueweather.data.ThroneRepository

class MainFragmentViewModel(private val repository: ThroneRepository): ViewModel() {

    val id: MutableLiveData<Int?> = MutableLiveData(null)

    suspend fun loadIdFromApi() {
        // Використання ThroneUseCase для отримання ідентифікатора персонажа з API
        val id = repository.getCharacters().body()?.firstOrNull()?.id
        // Присвоєння отриманого значення id до LiveData
        id?.let { this.id.value = it }
    }
}