package com.daveboy.baseframe4k

import com.daveboy.core.base.AbstractActivity
import com.daveboy.core.ext.startActivityExt
import kotlinx.android.synthetic.main.activity_login.*

class MainActivity: AbstractActivity(R.layout.activity_login) {

    override fun initView() {

    }

    override fun initListener() {

        test1.setOnClickListener {
            startActivityExt<TestActivity>(
            "1" to 2,
            "2" to "3"
        ) }
    }

    override fun initData() {
    }

    override fun initLast() {
    }
}