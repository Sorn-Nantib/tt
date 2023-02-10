package com.example.retrofitmyself.api

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitmyself.R
import com.example.retrofitmyself.model.GameModel
import com.squareup.picasso.Picasso

class MainAdapter(
    private val memesList: GameModel,
    private val context: Context,
    private val onClick: OnClick
) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var idUser: TextView
        var title: TextView
        var imageView: ImageView

        init {
            idUser = itemView.findViewById(R.id.id_user)
            title = itemView.findViewById(R.id.id_title)
            imageView = itemView.findViewById(R.id.imageView)
        }

    }

    interface OnClick {
        fun onClick(model: GameModel.Data.Meme)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.cardname, parent, false)
        return MainViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return memesList.data.memes.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val modelItem = memesList.data.memes[position]
        holder.idUser.text = modelItem.id
        holder.title.text = modelItem.name
        Picasso.get()
            .load(modelItem.url)
            .placeholder(R.drawable.blue)
            .error(R.drawable.lover)
            .into(holder.imageView);
        holder.itemView.setOnClickListener {
            onClick.onClick(modelItem)
        }


    }

}