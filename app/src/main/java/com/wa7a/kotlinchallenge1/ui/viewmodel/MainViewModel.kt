package com.wa7a.kotlinchallenge1.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wa7a.kotlinchallenge1.data.Medal
import com.wa7a.kotlinchallenge1.repository.MedalRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MedalRepository) : ViewModel() {
    val _medalsData = MutableLiveData<Medal>()
    val medalsData: LiveData<Medal>
        get() = _medalsData

    fun getMedals() = viewModelScope.launch {
        repository.getMedal(_medalsData)
        //_medalsData.value = AppModule.provideApi().getMedals()
//            RetrofitInstance.api.getMedals()
    }
}