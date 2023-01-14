package com.wa7a.kotlinchallenge1.api

import com.wa7a.kotlinchallenge1.data.Medal
import retrofit2.http.GET

interface MedalAPI {//datasource
    @GET("achievements")
    suspend fun getMedals(): Medal//Response<Medal>
}