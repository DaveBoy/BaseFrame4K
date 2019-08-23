package com.daveboy.core.mvp

import android.os.Bundle
import android.view.View
import com.daveboy.core.base.AbstractFragment

abstract class BaseMvpFragment<T: BasePresenter<IView,BaseModel>>: AbstractFragment(), IView{
    protected val presenter:T by lazy {
        createPresenter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this)
    }


    override fun onDestroyView() {
        presenter.detachView()
        super.onDestroyView()
    }

    abstract fun createPresenter():T
}