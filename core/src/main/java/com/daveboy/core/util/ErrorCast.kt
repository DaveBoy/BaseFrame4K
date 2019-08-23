package com.daveboy.core.util

import java.net.SocketTimeoutException

/**
 * 错误转换
 * @param throwable Throwable?
 * @return String
 */
fun Throwable?.errorCast():String{
    return when(this){
        is SocketTimeoutException->{
            "请求超时"
        }
        else ->{
            "未知错误"
        }
    }
}