package com.wa7a.kotlinchallenge1.data

import com.google.gson.annotations.SerializedName

data class Record(
    @SerializedName("active")
    val active: Boolean,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    var image: String,
    @SerializedName("label")
    val label: String,
    @SerializedName("title")
    val title: String
)

