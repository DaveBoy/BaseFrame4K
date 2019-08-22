package com.daveboy.core.mvp

abstract class BasePresenter: IPresenter {
    protected var view:IView?=null
    override fun attachView(v: IView) {
        view=v
    }

    override fun detachView() {
        view=null
    }

    override fun isViewAttached():Boolean {
        return view==null
    }
}