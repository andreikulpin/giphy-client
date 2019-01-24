package com.example.giphy_client.trending.view

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.giphy_client.base.IBaseView
import com.example.giphy_client.trending.presenter.GifListItem

@StateStrategyType(AddToEndStrategy::class)
interface ITrendingView : IBaseView {
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setItems(items: List<GifListItem>)

    fun addItems(items: List<GifListItem>)
}