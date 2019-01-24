package com.example.giphy_client.trending.view

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.giphy_client.R
import com.example.giphy_client.base.BaseFragment
import com.example.giphy_client.common.App
import com.example.giphy_client.trending.presenter.GifListItem
import com.example.giphy_client.trending.presenter.TrendingPresenter
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_trendings.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class TrendingFragment : BaseFragment(), ITrendingView {
    @Inject
    @InjectPresenter
    lateinit var presenter: TrendingPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    private lateinit var adapter: GifsAdapter
    private var pagingSubscription: Disposable? = null

    override fun getLayoutId() = R.layout.fragment_trendings

    override fun onCreate(savedInstanceState: Bundle?) {
        App.instance.appComponent.getMainActivityComponent()
            .inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun initView() {
        adapter = GifsAdapter().apply {
            setListener(object : GifsAdapter.IEventListener {
                override fun onItemClick(id: String) {
                    presenter.onItemClick(id)
                }
            })
        }
        list.adapter = adapter

        pagingSubscription = list.observePaging()
            .debounce(1, TimeUnit.SECONDS)
            .subscribe({
                presenter.onNeedMoreData()

            }, {})
    }

    override fun setItems(items: List<GifListItem>) {
        adapter.setItems(items)
    }

    override fun addItems(items: List<GifListItem>) {
        adapter.addItems(items)
    }

    override fun onDestroy() {
        super.onDestroy()
        pagingSubscription?.dispose()
    }
}