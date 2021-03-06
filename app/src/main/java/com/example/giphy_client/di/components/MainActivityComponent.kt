package com.example.giphy_client.di.components

import com.example.giphy_client.di.modules.GifInfoModule
import com.example.giphy_client.di.modules.MainActivityModule
import com.example.giphy_client.di.scopes.MainActivityScope
import com.example.giphy_client.main.view.MainActivity
import com.example.giphy_client.trending.view.TrendingFragment
import dagger.Subcomponent

@Subcomponent(modules = arrayOf(MainActivityModule::class))
@MainActivityScope
interface MainActivityComponent {
    fun inject(mainActivity: MainActivity)

    fun inject(fragment: TrendingFragment)

    fun getGifInfoComponent(module: GifInfoModule): GifInfoComponent
}