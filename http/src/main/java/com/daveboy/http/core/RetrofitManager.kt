package com.daveboy.http.core

import com.daveboy.core.util.DLogUtil
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Retrofit单例
 */
object RetrofitManager {
    private lateinit var retrofit: Retrofit


    fun init(baseurl:String){
        val httpLoggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
            DLogUtil.i(it)
        })
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val client: OkHttpClient =
            OkHttpClient
                .Builder()
                .addInterceptor(httpLoggingInterceptor).build()
        retrofit = Retrofit
            .Builder()
            .baseUrl(baseurl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()

    }
    fun <T>getService(clazz: Class<T>):T{
        return retrofit.create(clazz)
    }
}