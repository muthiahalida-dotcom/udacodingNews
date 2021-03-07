package com.perentjanadjaja.udacodingnews.network


import com.perentjanadjaja.udacodingnews.model.ResponseServer
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
@GET("/v2/everything")

fun getDataNews(@Query("q")category:String,
@Query("apiKey")apikey:String="3e0e534e162b47f88959edd2d6fb1692"): Call<ResponseServer>

}