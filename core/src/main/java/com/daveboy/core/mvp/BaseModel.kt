package com.daveboy.core.mvp

abstract class BaseModel {
    private var callback:(T)->Unit=null
    private var para:String[]
}