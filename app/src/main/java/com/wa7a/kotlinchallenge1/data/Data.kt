package com.wa7a.kotlinchallenge1.data

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("id")
    val id: Int,
    @SerializedName("label")
    val label: String,
    @SerializedName("records")
    var records: List<Record>,
    @SerializedName("title")
    var title: String
)