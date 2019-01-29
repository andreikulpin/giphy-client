package com.example.giphy_client.base

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.example.giphy_client.R

abstract class BaseFragment : MvpAppCompatFragment(), IBaseView {
    protected abstract fun getLayoutId(): Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutId(), null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    protected open fun initView() {}

    override fun showErrorMessage(message: String) {
        AlertDialog.Builder(context)
            .setMessage(message)
            .setPositiveButton(R.string.retry) { dialog, which ->  onPositiveButtonClick() }
            .setNegativeButton(R.string.cancel) { dialog, which ->  onNegativeButtonClick() }
            .create()
            .show()
    }

    protected open fun onPositiveButtonClick() {}

    protected open fun onNegativeButtonClick() {}

    override fun goBack() {
        activity?.onBackPressed()
    }
}