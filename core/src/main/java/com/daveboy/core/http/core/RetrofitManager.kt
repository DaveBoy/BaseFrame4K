package com.daveboy.core.http.core

import com.blankj.utilcode.util.AppUtils
import com.daveboy.core.util.logi
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
            logi(it)
        }).apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        val client: OkHttpClient =
            OkHttpClient
                .Builder()
                .apply {
                    if(AppUtils.isAppDebug())
                        addInterceptor(httpLoggingInterceptor)
                }
                .build()
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