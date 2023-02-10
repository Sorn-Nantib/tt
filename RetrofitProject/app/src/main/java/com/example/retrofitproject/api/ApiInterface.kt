package com.example.retrofitproject.api

import com.example.retrofitproject.model.PostModel
import com.example.retrofitproject.model.PostModelItem
import com.example.retrofitproject.model.PotoModel
import com.example.retrofitproject.model.Users
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {


//    @GET("/users")
//    suspend fun getUsers(): Response<Users>

//    @GET("/posts")
//    suspend fun getUserDetail(@Query("id") id: String): Response<Users>
    @GET("/photos")
 fun getData():Call<PotoModel>


}