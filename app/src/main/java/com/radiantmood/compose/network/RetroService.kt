package com.radiantmood.compose.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetroService {
    private val client by lazy { OkHttpClient.Builder().build() }

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("API BASE URL HERE")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
    }

    fun <T> buildService(service: Class<T>): T = retrofit.create(service)
}