package com.perentjanadjaja.udacodingnews.network

class ConfigNetwork {

    fun getRetrofit() {
        val retrofit: Retrofit = Retrofit.builder()
            .baseURL("https://newsapi.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service :NewsService= retrofit.create(NewsService::class.java)
        return service
    }
}