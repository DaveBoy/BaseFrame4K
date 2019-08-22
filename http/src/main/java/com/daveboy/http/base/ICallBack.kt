package com.daveboy.http.base

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