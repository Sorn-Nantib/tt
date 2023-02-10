package com.example.retrofitmyself.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiUtil {
    val BAS_URL = "https://api.imgflip.com"


 fun getInstance(): Retrofit {
        return  Retrofit.Builder().baseUrl(BAS_URL).addConverterFactory(GsonConverterFactory.create()).build()
    }




}