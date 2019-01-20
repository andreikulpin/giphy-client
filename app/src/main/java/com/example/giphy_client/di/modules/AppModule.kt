package com.example.giphy_client.di.modules

import android.content.Context
import com.example.giphy_client.trendings.presenter.TrendingPresenter
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(
    val context: Context
) {
    @Provides
    @Singleton
    fun provideContext(): Context {
        return context
    }
}