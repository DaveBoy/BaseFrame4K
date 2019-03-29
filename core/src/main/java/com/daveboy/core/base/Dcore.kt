package com.daveboy.core.base

import android.app.Application
import com.blankj.utilcode.util.Utils

/**
 * 部分工具初始化
 */
object Dcore {
    private lateinit var mContext:Application
    /**
     * 部分三方组件的初始化
     */
    fun init(context:Application){
        mContext=context
        Utils.init(mContext)
    }
}