package com.daveboy.core.util

import androidx.lifecycle.MutableLiveData
import com.daveboy.core.http.base.BaseResponse
import com.daveboy.core.mvvm.CustomException
import com.daveboy.core.mvvm.ViewState

fun <T>MutableLiveData<ViewState<T>>.parseResult(response:BaseResponse<T>){
    when{
        response.isSuccess()->this.value= ViewState.onSuccess(response.getData())
        else ->this.value= ViewState.onError(CustomException( response.getMessage()))
    }
}
