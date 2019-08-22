package com.daveboy.core.http.base

import com.daveboy.core.http.core.IResponse

/**
 * 规范的网络请求返回接口的基类
 */
data class BaseResponse<T>(
    private var code: Int,
    private var message: String?,
    private var data: T?
) : IResponse<T> {
    override fun isSuccess(): Boolean {
        return code == 200
    }

    override fun getCode(): Int {
        return code
    }

    override fun getMessage(): String? {
        return message
    }

    override fun getData(): T? {
        return data
    }

}