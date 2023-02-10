package com.example.retrofitmyself.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofitmyself.api.ApiInterface
import com.example.retrofitmyself.model.GameModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MemeRepository(private  val apiInterface: ApiInterface ) {
    private  val memesLiveData = MutableLiveData<GameModel>()

    val memes : LiveData<GameModel>
    get() = memesLiveData

    suspend fun getMemes(){
        val result = apiInterface.getDataFun()
        if (result.body() !=null){
            memesLiveData.postValue(result.body())
        }
        //why erro\\
//        result.enqueue(object : Callback<GameModel?> {
//            override fun onResponse(call: Call<GameModel?>, response: Response<GameModel?>) {
//                if (response.body() != null){
//                    memesLiveData.postValue(result.body())
//                }            }
//
//            override fun onFailure(call: Call<GameModel?>, t: Throwable) {
//
//            }
//
//        })
       
    }
}


