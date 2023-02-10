package com.example.retrofitproject.model


import com.google.gson.annotations.SerializedName

class PotoModel : ArrayList<PotoModel.PotoModelItem>(){
    data class PotoModelItem(
        @SerializedName("albumId")
        val albumId: Int,
        @SerializedName("id")
        val id: Int,
        @SerializedName("thumbnailUrl")
        val thumbnailUrl: String,
        @SerializedName("title")
        val title: String,
        @SerializedName("url")
        val url: String
    )
}