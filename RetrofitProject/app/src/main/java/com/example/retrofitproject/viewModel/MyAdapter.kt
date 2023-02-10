package com.example.retrofitproject.viewModel

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitproject.R
import com.example.retrofitproject.model.PostModelItem
import com.example.retrofitproject.model.PotoModel
import com.squareup.picasso.Picasso

class MyAdapter(private val context: Context, private val userList: PotoModel):RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class  ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var userId: TextView
        var title: TextView
        var imageMovie :ImageView

        init {
            userId =itemView.findViewById(R.id.userId)
            title = itemView.findViewById(R.id.title)
            imageMovie = itemView.findViewById(R.id.image_movie)


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.card,parent,false)
        return  ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.userId.text = userList[position].id.toString()
        holder.title.text = userList[position].title
        Picasso.get()
            .load(userList[position].url)
            .placeholder(R.drawable.logo)
            .error(R.drawable.lov)
            .into(holder.imageMovie);


    }
}