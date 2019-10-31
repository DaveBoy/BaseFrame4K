package com.daveboy.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

abstract class AbstractFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutID(), container, false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initPre()
        initView()
        initListener()
        initData()
        initLast()
    }


    abstract fun getLayoutID(): Int
    abstract fun initView()
    abstract fun initListener()
    abstract fun initData()
    abstract fun initLast()
}