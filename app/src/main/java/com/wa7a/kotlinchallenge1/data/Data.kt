package com.wa7a.kotlinchallenge1.data

data class Data(
    val id: Int,
    val label: String,
    val records: List<Record>,
    val title: String
)