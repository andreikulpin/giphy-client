package com.example.giphy_client.repository

import com.example.giphy_client.repository.entity.Response
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GiphyRepository @Inject constructor(
    private val api: GiphyApi
) {
    fun getTrenging(): Single<Response> = api.getTrending()
        .subscribeOn(Schedulers.io())
}