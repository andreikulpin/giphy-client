package com.example.giphy_client.trending.interactor

import com.example.giphy_client.repository.GiphyRepository
import javax.inject.Inject

class TrendingInteractor @Inject constructor(
    private val repository: GiphyRepository
) {
    fun getTrending(offset: Int, limit: Int) = repository.getTrenging(offset, limit)
}