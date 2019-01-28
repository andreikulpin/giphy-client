package com.example.giphy_client.info.interactor

import com.example.giphy_client.repository.GiphyRepository
import javax.inject.Inject

class GifInfoInteractor @Inject constructor(
    private val giphyRepository: GiphyRepository
) {
    fun getInfo(id: String) = giphyRepository.getGifById(id)
}
