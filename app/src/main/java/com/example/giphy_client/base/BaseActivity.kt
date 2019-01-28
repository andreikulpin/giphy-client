package com.example.giphy_client.base

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.example.giphy_client.R

abstract class BaseActivity : MvpAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        setUpView()
    }

    protected abstract fun getLayoutId(): Int

    abstract fun setUpView()

    fun addFragment(fragment: BaseFragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment, fragment::class.java.name)
            .addToBackStack(null)
            .commit()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 1) {
            finish()

        } else {
            super.onBackPressed()
        }
    }
}