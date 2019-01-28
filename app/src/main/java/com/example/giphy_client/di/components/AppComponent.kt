package com.example.giphy_client.di.components

import com.example.giphy_client.di.modules.ApiModule
import dagger.Component
import javax.inject.Singleton

@Component(modules = arrayOf(ApiModule::class))
@Singleton
interface AppComponent {
    fun getMainActivityComponent(): MainActivityComponent
}