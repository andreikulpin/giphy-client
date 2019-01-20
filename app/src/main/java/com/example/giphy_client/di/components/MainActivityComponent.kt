package com.example.giphy_client.di.components

import com.example.giphy_client.di.modules.MainActivityModule
import com.example.giphy_client.di.scopes.MainActivityScope
import com.example.giphy_client.main.view.MainActivity
import dagger.Subcomponent

@Subcomponent(modules = arrayOf(MainActivityModule::class))
@MainActivityScope
interface MainActivityComponent {
    fun inject(mainActivity: MainActivity)
}