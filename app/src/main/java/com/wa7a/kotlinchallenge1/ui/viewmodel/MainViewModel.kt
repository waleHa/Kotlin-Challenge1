package com.wa7a.kotlinchallenge1.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wa7a.kotlinchallenge1.api.RetrofitInstance
import com.wa7a.kotlinchallenge1.data.Data
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val _medalsData = MutableLiveData<List<Data>>()
    val medalsData: LiveData<List<Data>>
        get() = _medalsData

    fun getMedals() = viewModelScope.launch {
        val fetchedMedals = RetrofitInstance.api.getMedals().data
        _medalsData.value = fetchedMedals

    }



}