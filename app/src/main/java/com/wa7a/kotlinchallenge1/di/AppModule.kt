package com.wa7a.kotlinchallenge1.di

import com.wa7a.kotlinchallenge1.BuildConfig
import com.wa7a.kotlinchallenge1.api.MedalAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    //datasource
    const val baseUrl = BuildConfig.mBASE_URL

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    //get retrofit instance from here
    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit):MedalAPI =
        retrofit.create(MedalAPI::class.java)
}