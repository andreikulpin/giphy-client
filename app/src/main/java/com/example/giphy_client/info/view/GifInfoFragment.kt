package com.example.giphy_client.info.view

import android.content.Intent
import android.graphics.Typeface
import android.net.Uri
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.method.LinkMovementMethod
import android.text.style.StyleSpan
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.bumptech.glide.Glide
import com.example.giphy_client.R
import com.example.giphy_client.base.BaseFragment
import com.example.giphy_client.common.App
import com.example.giphy_client.di.modules.GifInfoModule
import com.example.giphy_client.info.presenter.GifInfoItem
import com.example.giphy_client.info.presenter.GifInfoPresenter
import com.example.giphy_client.ui.ClickableSpanImpl
import kotlinx.android.synthetic.main.fragment_gif_info.*
import javax.inject.Inject

class GifInfoFragment : BaseFragment(), IGifInfoView {
    @Inject
    @InjectPresenter
    lateinit var presenter: GifInfoPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun getLayoutId() = R.layout.fragment_gif_info

    override fun onCreate(savedInstanceState: Bundle?) {
        val gifId = arguments?.getString(GIF_ID_KEY, GifInfoPresenter.UNKNOWN_ID)
            ?: GifInfoPresenter.UNKNOWN_ID
        App.instance.mainActivityComponent
            .getGifInfoComponent(GifInfoModule(gifId))
            .inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun showInfo(info: GifInfoItem) {
        info.displayName?.let { displayName ->
            displayNameText.text = displayName
            displayNameText.visibility = View.VISIBLE
        }

        info.userName?.let { userName ->
            userNameText.text = SpannableStringBuilder().apply {
                appendClickableSpan(
                    span = userName,
                    markup = StyleSpan(Typeface.BOLD),
                    listener = { presenter.onUsernameClick() }
                )
            }
            userNameText.setMovementMethod(LinkMovementMethod.getInstance())
        }

        Glide.with(this)
            .load(info.url)
            .into(image)
    }

    override fun openUrl(url: String) {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
    }

    companion object {
        private const val GIF_ID_KEY = "GIF_ID_KEY"

        fun getInstance(gifId: String) = GifInfoFragment().apply {
            arguments = Bundle().apply {
                putString(GIF_ID_KEY, gifId)
            }
        }
    }

    fun SpannableStringBuilder.appendClickableSpan(span: CharSequence,
                                                   markup: Any,
                                                   listener: () -> Unit) {
        val startIndex = length
        val endIndex = startIndex + span.length

        append(span)
        setSpan(ClickableSpanImpl(listener), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        setSpan(markup, startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    }
}