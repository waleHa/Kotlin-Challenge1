package com.wa7a.kotlinchallenge1.repository

import androidx.lifecycle.MutableLiveData
import com.wa7a.kotlinchallenge1.api.MedalAPI
import com.wa7a.kotlinchallenge1.data.Medal
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MedalRepository @Inject constructor(private val medalAPI: MedalAPI) {
    suspend fun getMedal(mutableLiveData: MutableLiveData<Medal>) {
        val call: Call<Medal> = medalAPI.getMedals()

        call.enqueue(object : Callback<Medal> {
            override fun onFailure(call: Call<Medal>, t: Throwable) {
                mutableLiveData.postValue(null)
            }

            override fun onResponse(call: Call<Medal>, response: Response<Medal>) {
                mutableLiveData.postValue(response.body())
            }
        })
    }
}