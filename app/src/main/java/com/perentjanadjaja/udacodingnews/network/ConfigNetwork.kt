package com.perentjanadjaja.udacodingnews.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ConfigNetwork {

    fun getRetrofit() : NewsService{
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl ("https://newsapi.org")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service :NewsService= retrofit.create(NewsService::class.java)
        return service

    }
}