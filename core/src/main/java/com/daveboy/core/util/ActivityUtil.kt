package com.daveboy.core.util

import com.daveboy.core.base.AbstractActivity
import com.daveboy.core.mvvm.CustomException
import com.daveboy.core.mvvm.ViewState


fun <T> AbstractActivity.parseState(
    viewState: ViewState<T>,
    onSuccess: (T) -> Unit,
    onError: ((CustomException) -> Unit)? = null,
    onLoading: (() -> Unit)? = null
) {
    when (viewState) {
        is ViewState.Loading -> {
            showProgress()
            onLoading?.run { this }
        }
        is ViewState.Success -> {
            dismissProgress()
            onSuccess(viewState.data)
        }
        is ViewState.Error -> {
            dismissProgress()
            onError?.run { this(viewState.error) }
        }
    }
}
