package com.example.giphy_client.mapper

import com.example.giphy_client.repository.entity.Gif
import com.example.giphy_client.repository.entity.Response
import com.example.giphy_client.trending.presenter.GifListItem
import javax.inject.Inject

class GifListItemMapper @Inject constructor() {
    fun map(response: Response<List<Gif>>): List<GifListItem> = ArrayList<GifListItem>().apply {
        response.data.forEach { gif ->
            add(
                GifListItem(
                    id = gif.id,
                    title = gif.title,
                    url = gif.images.downsized.url
                )
            )
        }
    }
}