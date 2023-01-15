package com.wa7a.kotlinchallenge1.data

import com.google.gson.annotations.SerializedName

data class Medal
    (
    @SerializedName("data")
    val data: MutableList<Data>
)