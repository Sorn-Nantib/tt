package com.example.retrofitmyself

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitmyself.MemesViewModel.MemesViewModel
import com.example.retrofitmyself.MemesViewModel.MemesViewModelFacetory
import com.example.retrofitmyself.api.ApiInterface
import com.example.retrofitmyself.api.ApiUtil
import com.example.retrofitmyself.api.MainAdapter
import com.example.retrofitmyself.databinding.ActivityMainBinding
import com.example.retrofitmyself.model.GameModel
import com.example.retrofitmyself.repository.MemeRepository
import retrofit2.Callback

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainAdapter: MainAdapter
    private lateinit var memesViewModel: MemesViewModel
    private lateinit var linearLayoutManager: LinearLayoutManager
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycleView.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        binding.recycleView.layoutManager = linearLayoutManager

        getMydata()
        val apiInterface = ApiUtil.getInstance().create(ApiInterface::class.java)

        val memeRepository = MemeRepository(apiInterface)


        memesViewModel  = MemesViewModel(memeRepository)
        memesViewModel.getData()
        memesViewModel.memes.observe(this) {
            Log.d("SORN NANTIB", "OnCrREATES: ${it.toString()}")
            mainAdapter = MainAdapter(it, this,object :MainAdapter.OnClick{
                override fun onClick(model: GameModel.Data.Meme) {
                    val intent =Intent(this@MainActivity,DetailActivity::class.java)
                    intent.putExtra("card",model)
                    startActivity(intent)

                }

            })
            binding.recycleView.adapter = mainAdapter

            it.data.memes.iterator().forEach {
                it
                Log.d("", "NANTIB: ${it.name}\nimage")
            }
        }
//        mainAdapter.notifyDataSetChanged()
    }

    fun getMydata() {



    }
}


