package com.example.trueweather.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.trueweather.data.remote.ThroneAPIInterface
import com.example.trueweather.data.remote.model.ThroneHero

class ThronesRepository(private val api: ThroneAPIInterface) {

    fun getCharacters(): LiveData<List<ThroneHero>> {
        return api.getCharacters().execute().body()?.let {
            MutableLiveData<List<ThroneHero>>().apply {
                value = it.map { it.toThroneHero() }
            }
        } ?: MutableLiveData<List<ThroneHero>>().apply {
            value = emptyList()
        }
    }

    fun getCharacter(id: Int): LiveData<ThroneHero> {
        return api.getCharacter(id).execute().body()?.let {
            MutableLiveData<ThroneHero>().apply {
                value = it.toThroneHero()
            }
        } ?: MutableLiveData<ThroneHero>().apply {
            value = ThroneHero()
        }
    }

    private fun ThroneAPIResponse<ThroneHero>.toThroneHero(): ThroneHero {
        return ThroneHero(
            id = id,
            firstName = firstName,
            lastName = lastName,
            fullName = fullName,
            title = title,
            family = family,
            image = image,
            imgURL = imgURL
        )
    }
}




