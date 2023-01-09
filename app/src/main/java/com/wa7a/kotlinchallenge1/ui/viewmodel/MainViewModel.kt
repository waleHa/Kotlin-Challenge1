package com.wa7a.kotlinchallenge1.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wa7a.kotlinchallenge1.api.RetrofitInstance
import com.wa7a.kotlinchallenge1.data.Data
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val medalsData = mutableListOf<Data>()

    fun getMedals() = viewModelScope.launch {
        medalsData.addAll(RetrofitInstance.api.getMedals().data)
    }



}