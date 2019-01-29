package com.example.giphy_client.base

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface IBaseView : MvpView {
    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showErrorMessage(message: String)

    fun goBack()
}