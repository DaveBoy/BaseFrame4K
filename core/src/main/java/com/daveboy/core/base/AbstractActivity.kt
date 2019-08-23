package com.daveboy.core.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class AbstractActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutID())
        initPre()
        initView()
        initListener()
        initData()
        initLast()
    }

    protected fun initPre() = Unit

    abstract fun getLayoutID(): Int
    abstract fun initView()
    abstract fun initListener()
    abstract fun initData()
    abstract fun initLast()
}