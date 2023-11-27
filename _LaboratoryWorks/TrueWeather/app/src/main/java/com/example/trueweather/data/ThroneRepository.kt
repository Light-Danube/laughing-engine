package com.example.trueweather.data

import com.example.trueweather.data.remote.ThroneAPIFactory
import com.example.trueweather.data.remote.ThroneAPIInterface
import com.example.trueweather.data.remote.model.ThroneHero

class ThroneRepository : BaseRepository() {

    private val api: ThroneAPIInterface by lazy {
        ThroneAPIFactory().create()
    }

    fun getCharacters(): LiveData<List<ThroneHero>> {
        return api.getCharacters().execute().body()?.let {
            MutableLiveData<List<ThroneHero>>().apply {
                value = it
            }
        } ?: MutableLiveData<List<ThroneHero>>().apply {
            value = emptyList()
        }
    }

    fun getCharacter(id: Int): LiveData<ThroneHero> {
        return api.getCharacter(id).execute().body()?.let {
            MutableLiveData<ThroneHero>().apply {
                value = it
            }
        } ?: MutableLiveData<ThroneHero>().apply {
            value = ThroneHero()
        }
    }
}
