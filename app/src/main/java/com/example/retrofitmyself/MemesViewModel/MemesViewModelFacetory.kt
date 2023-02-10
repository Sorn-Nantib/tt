package com.example.retrofitmyself.MemesViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitmyself.repository.MemeRepository

class MemesViewModelFacetory (private  val memeRepository: MemeRepository):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MemesViewModel(memeRepository) as T
    }


}