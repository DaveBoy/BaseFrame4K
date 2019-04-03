package com.daveboy.http.base

import android.Manifest.permission.ACCESS_NETWORK_STATE
import android.support.annotation.RequiresPermission
import com.blankj.utilcode.util.NetworkUtils
import com.blankj.utilcode.util.ToastUtils
import com.daveboy.core.util.DLogUtil
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.net.SocketTimeoutException

/**
 * 基类Observer
 */
open abstract class BaseObserver<T>(private val showToast: Boolean = true) : Observer<T> {
    override fun onComplete() {
    }


    override fun onSubscribe(d: Disposable) {
        if (!NetworkUtils.isConnected()) {
            d.dispose()
            //当做连接超时处理
            onError(SocketTimeoutException("网络连接失败"))
            return
        }
    }

    override fun onNext(t: T) {
        onFinal(t)
    }

    override fun onError(e: Throwable) {
        if(showToast)
            ToastUtils.showShort("请求异常，请检查网络情况")
        DLogUtil.e(e.message?:"",e)
        onFinal(null,e)
    }

    /**
     * T表示成功的实体  error表示异常  都可能为空
     */
    @RequiresPermission(ACCESS_NETWORK_STATE)
    open abstract fun onFinal(t: T?,error:Throwable?=null)
}