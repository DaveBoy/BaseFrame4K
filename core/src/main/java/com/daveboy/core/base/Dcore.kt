package com.daveboy.core.base

import android.app.Application
import com.blankj.utilcode.util.Utils

/**
 * 部分工具初始化
 */
object Dcore {
    lateinit var application:Application
    /**
     * 部分三方组件的初始化
     */
    fun init(context:Application){
        application=context
        Utils.init(application)
    }
}