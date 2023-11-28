package com.example.trueweather.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import com.example.trueweather.data.remote.ThroneAPIInterface
import com.example.trueweather.data.remote.model.ThroneHero

class ThroneRepository(private val api: ThroneAPIInterface) {

    suspend fun getCharacters(): LiveData<List<ThroneHero>> {
        val response = api.getCharacters() // Get the Response object
        val data = response.body() // Extract the data from the Response object

        return if (data != null) {
            // Map the data to ThroneHero objects
            MutableLiveData<List<ThroneHero>>().apply {
                value = data.map {
                    ThroneHero(
                        it.id,
                        it.firstName, // Assign a value to firstName
                        it.lastName,
                        it.fullName,
                        it.title,
                        it.family, // Assign a value to family
                        it.image,
                        it.imgURL
                    )
                }
            }
        } else {
            // Handle the case when data is null
            MutableLiveData<List<ThroneHero>>().apply {
                value = emptyList()
            }
        }
    }

    suspend fun getCharacter(id: Int): LiveData<ThroneHero> {
        val response = api.getCharacter(id) // Get the Response object
        val data = response.body() // Extract the data from the Response object

        return if (data != null) {
            // Create a ThroneHero object from the data
            MutableLiveData<ThroneHero>().apply {
                value = ThroneHero(
                    data.id,
                    data.firstName, // Assign a value to firstName
                    data.lastName,
                    data.fullName,
                    data.title,
                    data.family, // Assign a value to family
                    data.image,
                    data.imgURL
                )
            }
        } else {
            // Handle the case when data is null
            MutableLiveData<ThroneHero>().apply {
                value = ThroneHero(0, "", "", "", "", "", "", "")
            }
        }
    }
}





