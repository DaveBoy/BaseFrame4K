package com.daveboy.core.mvp

interface IPresenter{
    /**
     * 链接 V和P
     * @param view V
     */
    fun attachView( v : IView)

    /**
     * 解除V和P的链接
     */
    fun detachView()
    /**
     * 用于网络请求完后检查V和P的链接情况
     */
    fun isViewAttached():Boolean
}