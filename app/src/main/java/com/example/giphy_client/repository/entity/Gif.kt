package com.example.giphy_client.repository.entity

data class Gif(
    val score: Int,
    val analytics: Analytics,
    val bitlyGifUrl: String,
    val bitlyUrl: String,
    val contentUrl: String,
    val embedUrl: String,
    val id: String,
    val images: Images,
    val importDatetime: String,
    val isSticker: Int,
    val rating: String,
    val slug: String,
    val source: String,
    val sourcePostUrl: String,
    val sourceTld: String,
    val title: String,
    val trendingDatetime: String,
    val type: String,
    val url: String,
    val user: User,
    val username: String
) {
    data class Analytics(
        val onclick: Onclick,
        val onload: Onload,
        val onsent: Onsent
    ) {
        data class Onsent(
            val url: String
        )

        data class Onclick(
            val url: String
        )

        data class Onload(
            val url: String
        )
    }

    data class User(
        val avatarUrl: String,
        val bannerUrl: String,
        val displayName: String,
        val isVerified: Boolean,
        val profileUrl: String,
        val username: String
    )

    data class Images(
        val wStill: WStill,
        val downsized: Downsized,
        val downsizedLarge: DownsizedLarge,
        val downsizedMedium: DownsizedMedium,
        val downsizedSmall: DownsizedSmall,
        val downsizedStill: DownsizedStill,
        val fixedHeight: FixedHeight,
        val fixedHeightDownsampled: FixedHeightDownsampled,
        val fixedHeightSmall: FixedHeightSmall,
        val fixedHeightSmallStill: FixedHeightSmallStill,
        val fixedHeightStill: FixedHeightStill,
        val fixedWidth: FixedWidth,
        val fixedWidthDownsampled: FixedWidthDownsampled,
        val fixedWidthSmall: FixedWidthSmall,
        val fixedWidthSmallStill: FixedWidthSmallStill,
        val fixedWidthStill: FixedWidthStill,
        val looping: Looping,
        val original: Original,
        val originalMp4: OriginalMp4,
        val originalStill: OriginalStill,
        val preview: Preview,
        val previewGif: PreviewGif,
        val previewWebp: PreviewWebp
    ) {
        data class DownsizedSmall(
            val height: String,
            val mp4: String,
            val mp4Size: String,
            val width: String
        )

        data class FixedHeightDownsampled(
            val height: String,
            val size: String,
            val url: String,
            val webp: String,
            val webpSize: String,
            val width: String
        )

        data class FixedHeightSmall(
            val height: String,
            val mp4: String,
            val mp4Size: String,
            val size: String,
            val url: String,
            val webp: String,
            val webpSize: String,
            val width: String
        )

        data class Original(
            val frames: String,
            val hash: String,
            val height: String,
            val mp4: String,
            val mp4Size: String,
            val size: String,
            val url: String,
            val webp: String,
            val webpSize: String,
            val width: String
        )

        data class Downsized(
            val height: String,
            val size: String,
            val url: String,
            val width: String
        )

        data class Looping(
            val mp4: String,
            val mp4Size: String
        )

        data class PreviewGif(
            val height: String,
            val size: String,
            val url: String,
            val width: String
        )

        data class DownsizedMedium(
            val height: String,
            val size: String,
            val url: String,
            val width: String
        )

        data class FixedHeight(
            val height: String,
            val mp4: String,
            val mp4Size: String,
            val size: String,
            val url: String,
            val webp: String,
            val webpSize: String,
            val width: String
        )

        data class FixedWidthSmallStill(
            val height: String,
            val size: String,
            val url: String,
            val width: String
        )

        data class FixedWidthSmall(
            val height: String,
            val mp4: String,
            val mp4Size: String,
            val size: String,
            val url: String,
            val webp: String,
            val webpSize: String,
            val width: String
        )

        data class FixedWidth(
            val height: String,
            val mp4: String,
            val mp4Size: String,
            val size: String,
            val url: String,
            val webp: String,
            val webpSize: String,
            val width: String
        )

        data class FixedWidthDownsampled(
            val height: String,
            val size: String,
            val url: String,
            val webp: String,
            val webpSize: String,
            val width: String
        )

        data class FixedHeightSmallStill(
            val height: String,
            val size: String,
            val url: String,
            val width: String
        )

        data class WStill(
            val height: String,
            val url: String,
            val width: String
        )

        data class PreviewWebp(
            val height: String,
            val size: String,
            val url: String,
            val width: String
        )

        data class FixedHeightStill(
            val height: String,
            val size: String,
            val url: String,
            val width: String
        )

        data class OriginalMp4(
            val height: String,
            val mp4: String,
            val mp4Size: String,
            val width: String
        )

        data class OriginalStill(
            val height: String,
            val size: String,
            val url: String,
            val width: String
        )

        data class Preview(
            val height: String,
            val mp4: String,
            val mp4Size: String,
            val width: String
        )

        data class FixedWidthStill(
            val height: String,
            val size: String,
            val url: String,
            val width: String
        )

        data class DownsizedLarge(
            val height: String,
            val size: String,
            val url: String,
            val width: String
        )

        data class DownsizedStill(
            val height: String,
            val size: String,
            val url: String,
            val width: String
        )
    }
}