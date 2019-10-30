package com.daveboy.core.mvvm

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daveboy.core.http.core.IResponse
import com.daveboy.core.util.paresException
import com.daveboy.core.util.parseResult
import kotlinx.coroutines.launch

abstract class BaseViewModel: ViewModel() {
    fun <T>launchRequest(request:suspend ()->IResponse<T>,viewStateLiveData:MutableLiveData<ViewState<T>>){
        viewModelScope.launch {
            runCatching {
                viewStateLiveData.value= ViewState.onLoading()
                request()
            }.onSuccess {
                viewStateLiveData.parseResult(it)
            }.onFailure {
                viewStateLiveData.paresException(it)
            }
        }
    }

}