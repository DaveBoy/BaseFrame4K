package com.daveboy.baseframe4k

import android.app.Application
import com.daveboy.core.base.Dcore
import com.daveboy.core.http.config.HttpConfig

class DApplication :Application(){
    override fun onCreate() {
        super.onCreate()
        Dcore.init(this)
        HttpConfig("https://www.wanandroid.com")
    }
}