package com.daveboy.core.mvvm

sealed class ViewState<out T> {
    companion object {
        fun onLoading() = Loading
        fun <T> onSuccess(data: T?) = Success(data)
        fun onError(error: CustomException) = Error(error)
    }

    object Loading : ViewState<Nothing>()
    data class Success<out T>(val data: T?) : ViewState<T>()
    data class Error(val error: CustomException) : ViewState<Nothing>()
}