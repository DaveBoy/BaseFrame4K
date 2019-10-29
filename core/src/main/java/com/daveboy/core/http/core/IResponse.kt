package com.daveboy.core.http.core

/**
 * 网络返回规范接口
 */
interface IResponse<T> {
    fun isSuccess():Boolean
    fun getCode():Int
    fun getMessage():String
    fun getData():T
}