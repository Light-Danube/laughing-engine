package com.example.trueweather.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.flow.map
import retrofit2.Response

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
                        id = it.id,
                        firstName = it.firstName, // Assign a value to firstName
                        lastName = it.lastName,
                        fullName = it.fullName,
                        title = it.title,
                        family = it.family, // Assign a value to family
                        image = it.image,
                        imgURL = it.imgURL
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
                    id = data.id,
                    firstName = data.firstName, // Assign a value to firstName
                    lastName = data.lastName,
                    fullName = data.fullName,
                    title = data.title,
                    family = data.family, // Assign a value to family
                    image = data.image,
                    imgURL = data.imgURL
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





