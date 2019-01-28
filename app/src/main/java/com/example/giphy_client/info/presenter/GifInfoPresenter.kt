package com.example.giphy_client.info.presenter

import com.arellomobile.mvp.InjectViewState
import com.example.giphy_client.base.BasePresenter
import com.example.giphy_client.di.GifId
import com.example.giphy_client.info.interactor.GifInfoInteractor
import com.example.giphy_client.info.view.IGifInfoView
import com.example.giphy_client.mapper.GifInfoItemMapper
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

@InjectViewState
class GifInfoPresenter @Inject constructor(
    @GifId private val id: String,
    private val interactor: GifInfoInteractor,
    private val gifInfoItemMapper: GifInfoItemMapper

) : BasePresenter<IGifInfoView>() {
    private var info: GifInfoItem? = null

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadData()
    }

    private fun loadData() {
        interactor.getInfo(id)
            .map(gifInfoItemMapper::map)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ info ->
                this.info = info
                viewState.showInfo(info)
        }, {})
            .connect()
    }

    fun onUsernameClick() {
        info?.userUrl?.let { url ->
            viewState.openUrl(url)
        }
    }
}