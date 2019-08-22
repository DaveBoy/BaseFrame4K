package com.daveboy.core.http.core

public interface ICallBack<out T> {
    /**
     * 成功
     * @return T
     */
    fun onSucess():T

    /**
     * 失败
     * @param msg String
     */
    fun onError(msg:String)

}