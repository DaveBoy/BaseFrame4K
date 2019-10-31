package com.daveboy.baseframe4k

import com.daveboy.core.base.AbstractActivity
import com.daveboy.core.ext.intentData
import com.daveboy.core.ext.intentDataString
import com.daveboy.core.util.logI

class TestActivity: AbstractActivity(R.layout.layout_user) {
    val data1 by intentData("1",1)

    val data2 by  intentData("2",2)
    val data3 by  intentDataString("3",null)
    override fun initView() {
        logI(data1.toString())
        logI(data2.toString())
        logI(data3.toString())
    }

    override fun initListener() {
    }

    override fun initData() {
    }

    override fun initLast() {
    }
}