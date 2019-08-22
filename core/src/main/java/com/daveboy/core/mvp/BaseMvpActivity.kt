package com.daveboy.core.mvp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseMvpActivity: AppCompatActivity(), IView{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initPresenter()
        getPresenter()?.attachView(this)
    }


    override fun onDestroy() {
        getPresenter()?.detachView()
        super.onDestroy()
    }

    /**
     * 初始化Presenter
     * @return P
     */
    abstract fun initPresenter()
    abstract fun getPresenter():IPresenter?
}