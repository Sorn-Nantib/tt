package com.example.retrofitproject.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object  ApiUtilities {
   const val BASE_UR = "https://jsonplaceholder.typicode.com"
       //"https://api.github.com"

    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_UR)
            .addConverterFactory(GsonConverterFactory.create()).build()


    }

}