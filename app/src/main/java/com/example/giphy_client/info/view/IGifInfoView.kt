package com.example.giphy_client.info.view

import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.giphy_client.base.IBaseView
import com.example.giphy_client.info.presenter.GifInfoItem

@StateStrategyType(AddToEndStrategy::class)
interface IGifInfoView : IBaseView {
    fun showInfo(info: GifInfoItem)

    @StateStrategyType(SkipStrategy::class)
    fun openUrl(url: String)
}