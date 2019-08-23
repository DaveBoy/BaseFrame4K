package com.daveboy.core.mvp

import android.os.Bundle
import com.daveboy.core.base.AbstractActivity

abstract class BaseMvpActivity<T: BasePresenter<IView,BaseModel>>: AbstractActivity(), IView{
    protected val presenter:T by lazy {
        createPresenter()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.attachView(this)
    }


    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }

    abstract fun createPresenter():T
}