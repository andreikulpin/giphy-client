package com.example.giphy_client.trending.view

import com.arellomobile.mvp.viewstate.strategy.*
import com.example.giphy_client.base.IBaseView
import com.example.giphy_client.trending.presenter.GifListItem

@StateStrategyType(AddToEndStrategy::class)
interface ITrendingView : IBaseView {
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setItems(items: List<GifListItem>)

    fun addItems(items: List<GifListItem>)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setRefreshing(isRefreshing: Boolean)
}