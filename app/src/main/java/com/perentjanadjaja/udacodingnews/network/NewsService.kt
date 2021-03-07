package com.perentjanadjaja.udacodingnews.network

import android.telecom.Call
import com.perentjanadjaja.udacodingnews.model.ResponseServer

interface NewsService {
@GET ()
fun getDataNews(): Call<ResponseServer>
}