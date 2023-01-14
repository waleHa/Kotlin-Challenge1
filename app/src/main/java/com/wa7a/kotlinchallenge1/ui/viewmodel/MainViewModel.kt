package com.wa7a.kotlinchallenge1.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wa7a.kotlinchallenge1.api.RetrofitInstance
import com.wa7a.kotlinchallenge1.data.Data
import com.wa7a.kotlinchallenge1.data.Medal
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val _medalsData = MutableLiveData<Medal>()
    val medalsData: LiveData<Medal>
        get() = _medalsData

    fun getMedals() = viewModelScope.launch {
        _medalsData.value = RetrofitInstance.api.getMedals()
    }
}