package com.daveboy.core.util

import android.app.Activity
import android.content.Intent
import com.daveboy.core.base.AbstractActivity
import com.daveboy.core.mvp.IView
import com.daveboy.core.mvvm.CustomException
import com.daveboy.core.mvvm.ViewState

inline fun <reified T : AbstractActivity> AbstractActivity.toActivity(params: Intent.() -> Unit = {}) {
    startActivity(Intent(this, T::class.java).apply {
        params()
    })
}

fun <T> IView.parseState(
    viewState: ViewState<T>,
    onSuccess: (T) -> Unit,
    onError: ((CustomException) -> Unit)? = null,
    onLoading: (() -> Unit)? = null
) {
    when (viewState) {
        is ViewState.Loading -> {
            showLoading()
            onLoading?.run { this }
        }
        is ViewState.Success -> {
            hideLoading()
            viewState.data?.run {
                onSuccess(this)
            }
        }
        is ViewState.Error -> {
            hideLoading()
            onError?.run { this(viewState.error) }
        }
    }
}
