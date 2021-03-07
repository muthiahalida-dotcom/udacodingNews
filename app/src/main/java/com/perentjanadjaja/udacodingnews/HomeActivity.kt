package com.perentjanadjaja.udacodingnews

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.util.Log
import android.widget.Toast
import com.perentjanadjaja.udacodingnews.model.ResponseServer
import com.perentjanadjaja.udacodingnews.network.ConfigNetwork
import kotlinx.android.synthetic.main.activity_home.*
import javax.security.auth.callback.Callback

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        softNews.setOnClickListener {
            val intent=Intent(this, ListViewActivity::class.java)
            intent.putExtra("Category", "soft")
            startActivity(intent)
        }

        hardNews.setOnClickListener {
            val intent=Intent(this, ListViewActivity::class.java)
            intent.putExtra("Category", "hard")
            startActivity(intent)
        }

        goodNews.setOnClickListener {
            val intent=Intent(this, ListViewActivity::class.java)
            intent.putExtra("Category", "good")
            startActivity(intent)
        }

        badNews.setOnClickListener {
            val intent=Intent(this, ListViewActivity::class.java)
            intent.putExtra("Category", "bad")
            startActivity(intent)
        }
    }
}