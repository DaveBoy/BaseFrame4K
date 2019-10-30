package com.daveboy.core.lifecycle

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.daveboy.core.InitContentProvider
import com.daveboy.core.ext.toast

/**
 * Created by luyao
 * on 2019/8/6 15:10
 */
class AppLifeObserverExt : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onForeground() {
        InitContentProvider.app.toast("应用进入前台")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onBackground() {
        InitContentProvider.app.toast("应用进入后台")
    }
}