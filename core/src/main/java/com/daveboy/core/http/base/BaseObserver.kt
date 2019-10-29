package com.daveboy.core.http.base

import com.blankj.utilcode.util.NetworkUtils
import com.daveboy.core.util.errorCast
import com.daveboy.core.util.logE
import com.daveboy.core.util.showToast
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.net.SocketTimeoutException

/**
 * 基类Observer
 */
abstract class BaseObserver<T>(private val showToast: Boolean = true) : Observer<T> {
    override fun onComplete() {
    }
    override fun onSubscribe(d: Disposable) {
        if (!NetworkUtils.isConnected()) {
            d.dispose()
            //当做连接超时处理
            onError(SocketTimeoutException())
            return
        }
    }

    override fun onNext(t: T) {
        onFinal(t)
    }

    override fun onError(e: Throwable) {
        logE(e)
        if(showToast)
            showToast(e.errorCast())
        onFinal(error = e)
    }

    /**
     * T表示成功的实体  error表示异常  都可能为空
     */
    open abstract fun onFinal(t: T?=null,error:Throwable?=null)
}