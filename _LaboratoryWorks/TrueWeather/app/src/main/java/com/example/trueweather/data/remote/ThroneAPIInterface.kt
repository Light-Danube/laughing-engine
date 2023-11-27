package com.example.trueweather.data.remote

import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ThroneAPIInterface {
    @GET("characters")
    suspend fun getCharacters(): Response<List<Character>>

    @GET("characters/{id}")
    suspend fun getCharacter(@Path("id") id: Int): Response<Character>
}