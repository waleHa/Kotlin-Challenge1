package com.wa7a.kotlinchallenge1.api

import com.wa7a.kotlinchallenge1.data.Medal
import retrofit2.Response
import retrofit2.http.GET

interface MedalAPI {
    @GET("achievements")
    suspend fun getMedals():Response<Medal>
}