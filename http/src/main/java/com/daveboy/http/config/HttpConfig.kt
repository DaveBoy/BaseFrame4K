package com.daveboy.http.config

import com.daveboy.http.core.RetrofitManager

/**
 * 需要配置的参数
 */
class HttpConfig (baseurl:String){
    init {
        RetrofitManager.init(baseurl)
    }


}