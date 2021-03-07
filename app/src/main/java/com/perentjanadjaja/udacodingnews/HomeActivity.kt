package com.perentjanadjaja.udacodingnews

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.util.Log
import android.widget.Toast
import com.perentjanadjaja.udacodingnews.model.ResponseServer
import com.perentjanadjaja.udacodingnews.network.ConfigNetwork
import javax.security.auth.callback.Callback

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        if (isConnect()){

        ConfigNetwork.getRetrofit().getDataNews().enqueue(object : Callback<ResponseServer>{})
        override fun onFailure(call: Call<ResponseServer>, t: Throwable){
            Log.d("terror sever",t.message)
        }

        override fun onResponse(
            call: Call<ResponseServer>,
            response: Response<ResponseServer>
        ){
            Log.d("response server",response.message())
        }

        fun isConnect():Boolean{
            val connect : ConnectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

            return connect.activeNetworkInfo!=null && connect.activeNetworkInfo.isConnected
        }

            Toast.makeText(this,"device tidak connect dengan internet",Toast.LENGTH_SHORT).show()}
    }
}