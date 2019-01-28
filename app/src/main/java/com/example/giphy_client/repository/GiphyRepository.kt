package com.example.giphy_client.repository

import com.example.giphy_client.repository.entity.Gif
import com.example.giphy_client.repository.entity.Response
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GiphyRepository @Inject constructor(
    private val api: GiphyApi
) {
    fun getTrenging(offset: Int, limit: Int): Single<Response<List<Gif>>> = api.getTrending(offset, limit)
        .subscribeOn(Schedulers.io())

    fun getGifById(id: String): Single<Response<Gif>> = api.getGifById(id)
        .subscribeOn(Schedulers.io())
}