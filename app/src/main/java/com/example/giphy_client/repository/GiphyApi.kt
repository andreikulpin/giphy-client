package com.example.giphy_client.repository

import com.example.giphy_client.repository.entity.Response
import io.reactivex.Single
import retrofit2.http.GET

interface GiphyApi {
    @GET("gifs/trending")
    fun getTrending(): Single<Response>
}