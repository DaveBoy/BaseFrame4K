package com.daveboy.core.util

import androidx.lifecycle.MutableLiveData
import com.daveboy.core.http.core.IResponse
import com.daveboy.core.mvvm.CustomException
import com.daveboy.core.mvvm.ViewState

fun <T> MutableLiveData<ViewState<T>>.parseResult(response: IResponse<T>) {
    when {
        response.isSuccess() -> this.value = ViewState.onSuccess(response.getData())
        else -> this.value = ViewState.onError(CustomException(response.getMessage()))
    }
}

fun <T> MutableLiveData<ViewState<T>>.paresException(exception: Throwable) {
    this.value = ViewState.onError(CustomException(exception))
}
