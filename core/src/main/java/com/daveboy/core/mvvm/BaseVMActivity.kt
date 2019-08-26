package com.daveboy.core.mvvm

import android.content.Intent
import android.os.Bundle
import com.daveboy.core.base.AbstractActivity
import com.daveboy.core.util.putExtraVararg
import java.lang.reflect.ParameterizedType

abstract class BaseVMActivity<VM:BaseViewModel>:AbstractActivity() {
    protected val viewModel:VM by lazy {
        createViewModel()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createObserver()
        Intent().putExtraVararg(
            "a" to 1
        )
    }

    @Suppress("UNCHECKED_CAST")
    open fun createViewModel():VM{
       return (this::class.java.genericSuperclass as ParameterizedType).actualTypeArguments[0] as VM
    }
    protected abstract fun createObserver()

}