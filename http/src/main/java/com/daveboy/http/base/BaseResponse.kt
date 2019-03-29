package com.daveboy.http.base

/**
 * 规范的网络请求返回接口的基类
 */
data class BaseResponse<T>(
    var code: Int ,
    var message: String?,
    var data: T?
)