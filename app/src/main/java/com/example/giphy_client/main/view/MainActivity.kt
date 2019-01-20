package com.example.giphy_client.main.view

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.giphy_client.R
import com.example.giphy_client.base.BaseActivity
import com.example.giphy_client.common.App
import com.example.giphy_client.main.presentation.IMainView
import com.example.giphy_client.main.presentation.MainPresenter
import javax.inject.Inject

class MainActivity : BaseActivity(), IMainView {
    @Inject
    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun getLayoutId() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        App.instance.appComponent.getMainActivityComponent()
            .inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun setUpView() {
    }

    override fun showTrendingScreen() {
    }
}
