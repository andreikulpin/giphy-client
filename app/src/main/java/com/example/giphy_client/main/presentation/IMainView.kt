package com.example.giphy_client.main.presentation

import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.giphy_client.base.IBaseView

@StateStrategyType(OneExecutionStateStrategy::class)
interface IMainView : IBaseView {
    @StateStrategyType(SkipStrategy::class)
    fun showTrendingScreen()

    @StateStrategyType(SkipStrategy::class)
    fun showGifInfoScreen(id: String)
}