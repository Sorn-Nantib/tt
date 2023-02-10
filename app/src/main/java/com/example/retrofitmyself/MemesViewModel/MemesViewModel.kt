package com.example.retrofitmyself.MemesViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitmyself.model.GameModel
import com.example.retrofitmyself.repository.MemeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MemesViewModel( private val memeRepository : MemeRepository) :ViewModel(){


    val memes: LiveData<GameModel>
    get() = memeRepository.memes

    fun getData(){
        viewModelScope.launch(Dispatchers.IO){
            memeRepository.getMemes()
        }
    }

}