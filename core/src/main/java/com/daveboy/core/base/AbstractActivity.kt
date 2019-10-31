package com.daveboy.core.base

import android.app.Dialog
import android.os.Bundle
import android.widget.ProgressBar
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.daveboy.core.R

abstract class AbstractActivity(@LayoutRes val layoutID:Int) : AppCompatActivity() {
    protected var dialog: Dialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutID)
        initView()
        initListener()
        initData()
        initLast()
    }


    abstract fun initView()
    abstract fun initListener()
    abstract fun initData()
    abstract fun initLast()
    fun showProgress() {
        dialog ?: let {
            dialog = Dialog(it)
            dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
            val progress = ProgressBar(it)
            progress.indeterminateDrawable = ContextCompat.getDrawable(it, R.drawable.progressbar)
            dialog?.setContentView(progress)
        }
        dialog?.show()
    }

    fun dismissProgress() {
        dialog?.dismiss()
    }
}