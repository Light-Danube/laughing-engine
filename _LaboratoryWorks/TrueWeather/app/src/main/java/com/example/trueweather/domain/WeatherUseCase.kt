package com.example.trueweather.domain

import androidx.lifecycle.LiveData
import com.example.trueweather.data.ThroneRepository
import com.example.trueweather.data.remote.model.ThroneHero

class WeatherUseCase (private val repository: ThroneRepository){
    suspend fun getCharacters(): LiveData<List<ThroneHero>> {
        return repository.getCharacters()
    }

    suspend fun getCharacter(id: Int): LiveData<ThroneHero> {
        return repository.getCharacter(id)
    }
}