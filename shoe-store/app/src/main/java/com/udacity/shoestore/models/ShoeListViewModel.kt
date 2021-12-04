package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeListViewModel: ViewModel()  {
    private val _listLiveData = MutableLiveData<List<Shoe>>()
    val listLiveData: LiveData<List<Shoe>>
        get() = _listLiveData
}