package com.daveboy.http.util

import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers
import com.daveboy.http.base.IResponse
import com.trello.rxlifecycle2.LifecycleTransformer
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer

/**
 * 网络请求结果预处理
 * @param transformer LifecycleTransformer<T>? 生命周期绑定
 * @return ObservableTransformer<IResponse<T>, T> T为具体的实体,不包含 IResponse
 */
fun <T>handleResult(transformer: LifecycleTransformer<Any>?=null): ObservableTransformer<IResponse<T>, T> {
    return object : ObservableTransformer<IResponse<T>, T> {
       override fun apply(upstream: Observable<IResponse<T>>): ObservableSource<T> {
            val observable = upstream
                /**
                 * 本地异常处理
                 * 异常处理操作符
                 * https://blog.csdn.net/nicolelili1/article/details/52152155
                 */
               /* .onExceptionResumeNext {
                    ErrorResumeFunction<BaseResponse<T>>()
                }*/
                .flatMap {
                    if(it.isSuccess()&&it.getData()!=null)
                        Observable.just(it.getData()!!)
                    else
                        Observable.error(Exception(it.getMessage()))
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
            return if (transformer == null) {
                observable
            } else observable.compose(transformer as LifecycleTransformer<T>)
        }
    }
}