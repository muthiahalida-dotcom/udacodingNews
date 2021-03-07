package com.perentjanadjaja.udacodingnews

import android.content.Context
import android.graphics.Bitmap
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.perentjanadjaja.udacodingnews.adapter.NewsAdapter
import com.perentjanadjaja.udacodingnews.model.News
import com.perentjanadjaja.udacodingnews.model.ResponseServer
import com.perentjanadjaja.udacodingnews.network.ConfigNetwork
import kotlinx.android.synthetic.main.activity_list_view.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class ListViewActivity : AppCompatActivity() {
    var category = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        category=intent.getStringExtra("Category")

        if (isConnect()){
            getNews()
        }
        else{
            Toast.makeText(this,"device tidak connect dengan internet",Toast.LENGTH_SHORT).show()
        }

    }

    fun getNews(){
        val service= ConfigNetwork()
        val call = service.getRetrofit().getDataNews(category)
            call.enqueue(object :retrofit2.Callback<ResponseServer>{
                override fun onFailure(call: Call<ResponseServer>, t: Throwable) {
                    Toast.makeText(this@ListViewActivity,"gagal", Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(
                    call: Call<ResponseServer>,
                    response: Response<ResponseServer>
                ) {
                    if (response.isSuccessful){
                        val news = response.body()?.articles
                        showNews(news.orEmpty())
                    }

                }

            })
    }

    fun showNews(news : List<News>){
        val adapter = NewsAdapter(this, news)
        recyclerView.adapter = adapter

        recyclerView.layoutManager=LinearLayoutManager(this)
    }

    fun isConnect():Boolean{
        val connect : ConnectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        return connect.activeNetworkInfo!=null && connect.activeNetworkInfo.isConnected
    }
}