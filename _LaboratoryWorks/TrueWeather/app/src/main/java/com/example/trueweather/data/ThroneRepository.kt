package com.example.trueweather.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.flow.map
import com.example.trueweather.data.remote.ThroneAPIInterface
import com.example.trueweather.data.remote.model.ThroneHero

class ThroneRepository(private val api: ThroneAPIInterface) {
    suspend fun getCharacters(): LiveData<List<ThroneHero>> {
        return api.getCharacters().await().body()?.let {
            MutableLiveData<List<ThroneHero>>().apply {
                value = it.map { it.toThroneHero() }
            }
        } ?: MutableLiveData<List<ThroneHero>>().apply {
            value = emptyList()
        }
    }

    suspend fun getCharacter(id: Int): LiveData<ThroneHero> {
        return api.getCharacter(id).await().body()?.let {
            MutableLiveData<ThroneHero>().apply {
                value = it.toThroneHero()
            }
        } ?: MutableLiveData<ThroneHero>().apply {
            value = ThroneHero(
                0,
                "",
                 "",
                "",
                "",
                "",
                "",
                "")
        }
    }
}




