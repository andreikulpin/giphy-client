package com.example.giphy_client.main.presentation

import com.arellomobile.mvp.InjectViewState
import com.example.giphy_client.base.BasePresenter
import com.example.giphy_client.di.IntentData
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor(
    @IntentData private val intentData: String
) : BasePresenter<IMainView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        if (intentData == EMPTY_DATA) {
            viewState.showTrendingScreen()
        } else {
            val gifId = intentData.split("-").last()
            viewState.showGifInfoScreen(gifId)
        }
    }

    companion object {
        const val EMPTY_DATA = ""
    }
}