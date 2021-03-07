package com.perentjanadjaja.udacodingnews.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.perentjanadjaja.udacodingnews.R
import com.perentjanadjaja.udacodingnews.model.News
import kotlinx.android.synthetic.main.item_news.view.*

class NewsAdapter(val context: Context, val list: List<News>): RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    inner class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindView(data: News){
            itemView.textViewAuthor.text = data.author
            itemView.textViewTitle.text = data.title
            Glide.with(context).load(data.urlToImage).into(itemView.imageView)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(LayoutInflater.from(context).inflate(R.layout.item_news,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bindView(list[position])
    }
}