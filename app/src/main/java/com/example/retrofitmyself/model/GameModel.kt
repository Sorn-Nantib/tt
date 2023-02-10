package com.example.retrofitmyself.model



import com.google.gson.annotations.SerializedName


data class GameModel(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("success")
    val success: Boolean
) {
    data class Data(
        @SerializedName("memes")
        val memes: List<Meme>
    ) {
        data class Meme(
            @SerializedName("box_count")
            val boxCount: Int,
            @SerializedName("captions")
            val captions: Int,
            @SerializedName("height")
            val height: Int,
            @SerializedName("id")
            val id: String,
            @SerializedName("name")
            val name: String,
            @SerializedName("url")
            val url: String,
            @SerializedName("width")
            val width: Int
        )  : java.io.Serializable

    }
}