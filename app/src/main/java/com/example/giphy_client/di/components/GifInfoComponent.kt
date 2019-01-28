package com.example.giphy_client.di.components

import com.example.giphy_client.di.modules.GifInfoModule
import com.example.giphy_client.di.scopes.GifInfoScope
import com.example.giphy_client.info.view.GifInfoFragment
import dagger.Subcomponent

@Subcomponent(modules = arrayOf(GifInfoModule::class))
@GifInfoScope
interface GifInfoComponent {
    fun inject(fragment: GifInfoFragment)
}