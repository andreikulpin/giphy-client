package com.example.giphy_client.di.components

import com.example.giphy_client.di.modules.AppModule
import dagger.Component
import javax.inject.Singleton

@Component(modules = arrayOf(AppModule::class))
@Singleton
interface AppComponent {
    fun getMainActivityComponent(): MainActivityComponent
}