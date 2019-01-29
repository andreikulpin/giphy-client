package com.example.giphy_client.main.view

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.giphy_client.R
import com.example.giphy_client.base.BaseActivity
import com.example.giphy_client.common.App
import com.example.giphy_client.di.modules.MainActivityModule
import com.example.giphy_client.info.view.GifInfoFragment
import com.example.giphy_client.main.presentation.IMainView
import com.example.giphy_client.main.presentation.MainPresenter
import com.example.giphy_client.trending.view.TrendingFragment
import javax.inject.Inject

class MainActivity : BaseActivity(), IMainView {
    @Inject
    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun getLayoutId() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        val data = intent?.data?.lastPathSegment ?: MainPresenter.EMPTY_DATA
        App.instance.mainActivityComponent = App.instance.appComponent
            .getMainActivityComponent(MainActivityModule(data)).apply {
                inject(this@MainActivity)
            }
        super.onCreate(savedInstanceState)
    }

    override fun setUpView() {
    }

    override fun showTrendingScreen() {
        addFragment(TrendingFragment())
    }

    override fun showGifInfoScreen(id: String) {
        addFragment(GifInfoFragment.getInstance(id))
    }
}
