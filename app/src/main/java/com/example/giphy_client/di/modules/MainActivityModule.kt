package com.example.giphy_client.di.modules

import com.example.giphy_client.di.IntentData
import com.example.giphy_client.di.scopes.MainActivityScope
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule(
    private val id: String
) {
    @Provides
    @MainActivityScope
    @IntentData
    fun provideGifId(): String = id
}