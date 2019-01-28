package com.example.giphy_client.mapper

import com.example.giphy_client.di.BaseUrl
import com.example.giphy_client.info.presenter.GifInfoItem
import com.example.giphy_client.repository.entity.Gif
import com.example.giphy_client.repository.entity.Response
import javax.inject.Inject

class GifInfoItemMapper @Inject constructor(
    @BaseUrl private val baseUrl: String
) {
    fun map(response: Response<Gif>): GifInfoItem = response.data.let { gif ->
            GifInfoItem(
                url = response.data.images.downsized.url,
                displayName = gif.user?.displayName,
                userName = gif.user?.username?.let { userName -> "@$userName" },
                userUrl = gif.user?.username?.let { userName -> "$baseUrl$userName" }
            )
    }
}