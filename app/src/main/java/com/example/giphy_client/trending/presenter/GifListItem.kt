package com.example.giphy_client.trending.presenter

data class GifListItem(
    val id: String,
    val title: String,
    val url: String? = null
)