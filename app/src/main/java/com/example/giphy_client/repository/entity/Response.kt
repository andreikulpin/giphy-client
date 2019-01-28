package com.example.giphy_client.repository.entity

data class Response<out DataType>(
    val data: DataType,
    val meta: Meta,
    val pagination: Pagination
) {
    data class Meta(
        val msg: String,
        val responseId: String,
        val status: Int
    )

    data class Pagination(
        val count: Int,
        val offset: Int,
        val totalCount: Int
    )
}