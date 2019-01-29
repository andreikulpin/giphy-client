package com.example.giphy_client.trending.presenter

import com.arellomobile.mvp.InjectViewState
import com.example.giphy_client.base.BasePresenter
import com.example.giphy_client.trending.interactor.TrendingInteractor
import com.example.giphy_client.trending.view.ITrendingView
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

@InjectViewState
class TrendingPresenter @Inject constructor(
    private val interactor: TrendingInteractor
) : BasePresenter<ITrendingView>() {
    companion object {
        private const val LIMIT = 50
    }

    private var offset = 0
    private var isLoading = false

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadData()
    }

    fun loadData() {
        interactor.getTrending(offset, LIMIT)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                isLoading = true
                viewState.setRefreshing(true)
            }
            .doAfterTerminate {
                isLoading = false
                viewState.setRefreshing(false)
            }
            .subscribe({ response ->
                offset += response.pagination.count

                val items = ArrayList<GifListItem>().also { items ->
                    response.data.forEach { gif ->
                        items.add(
                            GifListItem(
                                id = gif.id,
                                title = gif.title,
                                url = gif.images.downsized.url
                            )
                        )
                    }
                }
                viewState.setItems(items)

            }, { exception ->
                exception.message?.let { message ->
                    viewState.showErrorMessage(message)
                }
            })
            .connect()
    }

    fun onNeedMoreData() {
        if (isLoading) {
            return
        }

        interactor.getTrending(offset, LIMIT)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { isLoading = true }
            .doAfterTerminate { isLoading = false }
            .subscribe({ response ->
                offset += response.pagination.count

                val items = ArrayList<GifListItem>().also { items ->
                    response.data.forEach { gif ->
                        items.add(
                            GifListItem(
                                id = gif.id,
                                title = gif.title,
                                url = gif.images.downsized.url
                            )
                        )
                    }
                }
                viewState.addItems(items)

            }, {})
            .connect()
    }

    fun onRefreshPull() {
        offset = 0
        viewState.setRefreshing(true)
        loadData()
    }

    fun onItemClick(itemId: String) {
        viewState.goToInfoScreen(itemId)
    }

    fun onErrorDialogPositiveClick() {
        loadData()
    }

    fun onErrorDialogNegativeClick() {
        viewState.goBack()
    }
}