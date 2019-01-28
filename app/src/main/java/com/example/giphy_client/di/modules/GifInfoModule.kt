package com.example.giphy_client.di.modules

import com.example.giphy_client.BuildConfig
import com.example.giphy_client.di.BaseUrl
import com.example.giphy_client.di.GifId
import com.example.giphy_client.di.scopes.GifInfoScope
import com.example.giphy_client.info.interactor.GifInfoInteractor
import com.example.giphy_client.info.presenter.GifInfoPresenter
import dagger.Module
import dagger.Provides

@Module(includes = arrayOf(ApiModule::class, ContextModule::class))
class GifInfoModule(
    val gifId: String
) {
    @Provides
    @GifInfoScope
    @GifId
    fun provideGifId(): String = gifId

    @Provides
    @GifInfoScope
    @BaseUrl
    fun provideBaseUrl(): String = BuildConfig.GIPHY_BASE_URL
}