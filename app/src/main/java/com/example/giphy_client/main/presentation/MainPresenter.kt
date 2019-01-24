package com.example.giphy_client.main.presentation

import com.arellomobile.mvp.InjectViewState
import com.example.giphy_client.base.BasePresenter
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor() : BasePresenter<IMainView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showTrendingScreen()
    }
}