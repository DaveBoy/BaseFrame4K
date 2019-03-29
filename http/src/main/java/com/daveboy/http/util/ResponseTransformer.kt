package com.daveboy.http.util

import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers
import com.daveboy.http.base.BaseResponse
import com.trello.rxlifecycle2.LifecycleTransformer
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer

/**
 * 网络请求结果预处理
 * @param transformer LifecycleTransformer<T>? 生命周期绑定
 * @return ObservableTransformer<BaseResponse<T>, T> T为具体的实体,不包含BaseResponse
 */
fun <T> handleResult(transformer: LifecycleTransformer<T>?): ObservableTransformer<BaseResponse<T>, T> {
    return object : ObservableTransformer<BaseResponse<T>, T> {
       override fun apply(upstream: Observable<BaseResponse<T>>): ObservableSource<T> {
            val observable = upstream
                /**
                 * TODO 待测试  实体接收不符合问题
                 * 异常处理操作符
                 * https://blog.csdn.net/nicolelili1/article/details/52152155
                 */
               /* .onExceptionResumeNext {
                    ErrorResumeFunction<BaseResponse<T>>()
                }*/
                .flatMap {
                    if(it.data!=null)
                        Observable.just(it.data!!)
                    else
                        Observable.error(Exception(it.message))
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
            return if (transformer == null) {
                observable
            } else observable.compose(transformer)
        }
    }
}