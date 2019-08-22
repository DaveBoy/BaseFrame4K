package com.daveboy.core.util

import java.net.SocketTimeoutException

/**
 * 错误转换
 * @param throwable Throwable?
 * @return String
 */
fun errorCast(throwable: Throwable?):String{
    if(throwable==null){
        return "未知错误"
    }
    return when(throwable){
        is SocketTimeoutException->{
            "请求超时"
        }
        else ->{
            "未知错误"
        }
    }
}