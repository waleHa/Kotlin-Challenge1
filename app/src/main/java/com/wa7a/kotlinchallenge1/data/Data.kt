package com.wa7a.kotlinchallenge1.data

data class Data(
    val id: Int,
    val label: String,
    var records: List<Record>,
    var title: String
)