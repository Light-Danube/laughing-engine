package com.example.trueweather.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ThroneAPIFactory {
    fun create(): ThroneAPIInterface {
        return Retrofit.Builder()
            .baseUrl("https://thronesapi.com/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ThroneAPIInterface::class.java)
    }


}