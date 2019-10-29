package com.daveboy.core.util

import com.orhanobut.logger.Logger

/**
 * 日志类
 */
fun logE(throwable: Throwable? , message: String ="",vararg args: Any? ){
    Logger.e(throwable,message,args)
}
fun logI(message: String ,vararg args: Any?){
    Logger.i(message,args)
}
fun logW(message: String ,vararg args: Any?){
    Logger.w(message,args)
}
fun logD(message: String ,vararg args: Any?){
    Logger.d(message,args)
}