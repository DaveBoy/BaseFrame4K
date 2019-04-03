package com.daveboy.baseframe4k.api

import com.daveboy.baseframe4k.bean.LoginResponse
import com.daveboy.http.base.BaseResponse
import io.reactivex.Observable
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * 网络接口
 */
interface ApiService {
    /**
     * 登录
     */
    @POST("/user/login")
    fun login(@Query("username")username:String, @Query("password")password:String): Observable<WanResponse<LoginResponse>>
}