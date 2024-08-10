package com.example.mycollege.data.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel:ViewModel() {
    private val _httpe = MutableLiveData("Data")
    val httpe : LiveData<String>get()=_httpe
}