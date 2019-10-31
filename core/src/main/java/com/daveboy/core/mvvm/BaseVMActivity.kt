package com.daveboy.core.mvvm

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.lifecycle.ViewModelProvider
import com.daveboy.core.base.AbstractActivity
import java.lang.reflect.ParameterizedType

abstract class BaseVMActivity<VM:BaseViewModel>(@LayoutRes layoutID:Int):AbstractActivity(layoutID) {
    protected val viewModel:VM by lazy {
        createViewModel()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createObserver()
    }

    @Suppress("UNCHECKED_CAST")
    open fun createViewModel():VM{
       return ViewModelProvider(this).get(provideVM())
    }
    protected abstract fun createObserver()

    open fun provideVM():Class<VM>{
       return (this::class.java.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<VM>
    }
}