package com.daveboy.core.http.core

interface ICompleteCallBack<out T>: ICallBack<T> {
    /**
     * 不管成功失败都进行回调
     */
    fun onComplete()
}