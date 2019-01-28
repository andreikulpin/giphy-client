package com.example.giphy_client.repository

import com.example.giphy_client.repository.entity.Gif
import com.example.giphy_client.repository.entity.Response
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GiphyApi {
    @GET("gifs/trending")
    fun getTrending(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Single<Response<List<Gif>>>

    @GET("gifs/{gif_id}")
    fun getGifById(
        @Path("gif_id") gifId: String
    ): Single<Response<Gif>>
}