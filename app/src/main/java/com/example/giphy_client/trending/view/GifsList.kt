package com.example.giphy_client.trending.view

import android.content.Context
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import io.reactivex.Observable
import io.reactivex.ObservableEmitter

class GifsList @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0

) : RecyclerView(context, attrs, defStyle) {
    companion object {
        private const val DEFAULT_COLUMN_COUNT = 3
        private const val ROWS_NUMBER_BEFORE_UPDATE = 5
    }

    init {
        layoutManager = GridLayoutManager(context, DEFAULT_COLUMN_COUNT)
    }

    fun observePaging() = Observable.create { emitter: ObservableEmitter<Any> ->
        val scrollListener = object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                (layoutManager as GridLayoutManager).let {layoutManager ->
                    val lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition()
                    val totalItemsCount = layoutManager.itemCount

                    if (lastVisibleItemPosition >=
                        totalItemsCount - DEFAULT_COLUMN_COUNT * ROWS_NUMBER_BEFORE_UPDATE)
                    {
                        emitter.onNext(Any())
                    }
                }
            }
        }

        addOnScrollListener(scrollListener)

        emitter.setCancellable {
            removeOnScrollListener(scrollListener)
        }
    }
}