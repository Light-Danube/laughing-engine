package com.example.trueweather.data.remote

import com.example.trueweather.data.remote.model.ThroneHero
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ThroneAPIInterface {
    @GET("characters")
    suspend fun getCharacters(): Response<List<ThroneHero>>

    @GET("characters/{id}")
    suspend fun getCharacter(@Path("id") id: Int): Response<ThroneHero>
}