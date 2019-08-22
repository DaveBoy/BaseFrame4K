package com.daveboy.baseframe4k.api

import com.daveboy.core.http.core.RetrofitManager

/**
 * 简化写法
 */
val RetrofitManager.service: ApiService
    get() = RetrofitManager.getService(ApiService::class.java)