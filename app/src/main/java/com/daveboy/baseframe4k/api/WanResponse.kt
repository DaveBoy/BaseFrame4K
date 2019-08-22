package com.daveboy.baseframe4k.api

import com.daveboy.core.http.core.IResponse

/**
 * 玩android返回数据格式
 * @param T
 * @property errorCode Int
 * @property errorMsg String?
 * @property data T?
 * @constructor
 */
data class WanResponse<T>(
    private var errorCode: Int,
    private var errorMsg: String?,
    private var data: T?
) : IResponse<T> {
    override fun isSuccess(): Boolean {
        return errorCode == 0
    }

    override fun getCode(): Int {
        return errorCode
    }

    override fun getMessage(): String? {
        return errorMsg
    }

    override fun getData(): T? {
        return data
    }

}