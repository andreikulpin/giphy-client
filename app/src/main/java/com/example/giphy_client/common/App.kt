package com.example.giphy_client.common

import android.app.Application
import com.example.giphy_client.di.components.AppComponent
import com.example.giphy_client.di.components.DaggerAppComponent
import com.example.giphy_client.di.modules.ContextModule

class App : Application() {
    companion object {
        lateinit var instance: App private set
    }

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this

        appComponent = DaggerAppComponent.builder()
            .contextModule(ContextModule(applicationContext))
            .build()
    }
}