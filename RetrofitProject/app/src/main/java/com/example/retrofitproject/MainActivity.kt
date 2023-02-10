package com.example.retrofitproject

import android.app.Activity
import android.nfc.NfcAdapter
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global
import android.renderscript.ScriptGroup.Binding
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.retrofitproject.api.ApiInterface
import com.example.retrofitproject.api.ApiUtilities
import com.example.retrofitproject.api.ApiUtilities.getInstance
import com.example.retrofitproject.databinding.ActivityMainBinding
import com.example.retrofitproject.model.PostModelItem
import com.example.retrofitproject.model.PotoModel
import com.example.retrofitproject.viewModel.MyAdapter
import com.google.android.material.tabs.TabLayout.TabGravity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(

) {


    private lateinit var binding: ActivityMainBinding
    private lateinit var myAdapter: MyAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)


//      val  usersApi = ApiUtilities.getInstance().create(ApiInterface::class.java)
//
//
//         GlobalScope.launch {
//
//             val result = usersApi.getUsers()
//             if (result.body() !=null){
//                 Log.d("SHUBH", "onCreate : $${result.body()}")
//
//                 result.body()!!.iterator().forEach {
//                     Log.d("shubh", "name: ${it.login}")
//                 }
//             }
//         }
        binding.recycleView.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        binding.recycleView.layoutManager = linearLayoutManager
        getMyData()
    }

    private fun getMyData() {
        val retrofitBuilder = ApiUtilities.getInstance().create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData()


        retrofitData.enqueue(object : Callback<PotoModel?> {
            override fun onResponse(call: Call<PotoModel?>, response: Response<PotoModel?>) {
                val responseBody = response.body()!!

                myAdapter = MyAdapter(baseContext, responseBody)
                myAdapter.notifyDataSetChanged()
                binding.recycleView.adapter = myAdapter

            }

            override fun onFailure(call: Call<PotoModel?>, t: Throwable) {

            }

        })
    }



}






