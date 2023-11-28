package com.example.trueweather.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.trueweather.data.ThroneRepository

class MainFragmentViewModel(private val repository: ThroneRepository): ViewModel() {

    val id: MutableLiveData<List<Int>> = MutableLiveData(emptyList())


    suspend fun loadIdFromApi() {
        // Використання ThroneUseCase для отримання ідентифікаторів персонажів з API
        val ids = repository.getCharacters().body()?.map { it.id } ?: emptyList()
        // Присвоєння отриманого значення id до LiveData
        this.id.value = ids
    }
}