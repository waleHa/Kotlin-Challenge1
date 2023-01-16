package com.wa7a.kotlinchallenge1.api


import com.wa7a.kotlinchallenge1.data.Medal
import retrofit2.Call
import retrofit2.http.GET

interface MedalAPI {
    @GET("achievements")
    fun getMedals(): Call<Medal>
}