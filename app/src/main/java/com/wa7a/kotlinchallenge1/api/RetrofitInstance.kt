package com.wa7a.kotlinchallenge1.api

import com.wa7a.kotlinchallenge1.utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Network Module
class RetrofitInstance {
    companion object {
        private val retrofit by lazy {

            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        val api by lazy {
            retrofit.create(MedalAPI::class.java)
        }
    }
}