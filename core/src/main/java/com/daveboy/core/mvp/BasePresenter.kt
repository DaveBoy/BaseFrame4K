package com.daveboy.core.mvp

abstract class BasePresenter<V:IView, out M : BaseModel> {
    protected var view: V? = null
    protected val model: M by lazy {
        createModel()
    }


    fun attachView(v: V) {
        view = v
    }

    fun detachView() {
        view = null
    }

    fun isViewAttached() = view == null
    abstract fun createModel(): M
}