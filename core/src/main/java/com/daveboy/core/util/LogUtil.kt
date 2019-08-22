package com.daveboy.core.util

import com.orhanobut.logger.Logger

/**
 * 日志类
 */
fun loge(throwable: Throwable? , message: String ="",vararg args: Any? ){
    Logger.e(throwable,message,args)
}
fun logi(message: String ,vararg args: Any?){
    Logger.i(message,args)
}
fun logw(message: String ,vararg args: Any?){
    Logger.w(message,args)
}
fun logd(message: String ,vararg args: Any?){
    Logger.d(message,args)
}