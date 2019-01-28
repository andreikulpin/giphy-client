package com.example.giphy_client.ui

import android.text.TextPaint
import android.text.style.ClickableSpan
import android.view.View

class ClickableSpanImpl(private val listener: () -> Unit) : ClickableSpan() {
    override fun onClick(p0: View?) {
        listener()
    }

    override fun updateDrawState(textPaint: TextPaint) {
        textPaint.isUnderlineText = false
    }
}