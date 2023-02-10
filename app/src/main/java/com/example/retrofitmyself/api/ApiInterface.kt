package com.example.retrofitmyself.api

import com.example.retrofitmyself.model.GameModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("/get_memes")
    suspend fun getDataFun(): Response<GameModel>


    //Response and call ?
    //why abstract and fun  by model


}