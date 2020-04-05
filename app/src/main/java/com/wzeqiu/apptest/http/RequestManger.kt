package com.wzeqiu.apptest.http

import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

class RequestManger {

    companion object {

        const val BASE_URL: String = "https://data.gov.sg/"


        private val instance: RequestManger by lazy {
            RequestManger()
        }

        val requestInterface = instance.create(NetInterface::class.java)
    }

    private val fileSize: Long = 1024 * 1024 * 10
//    private val cache: Cache = Cache(File(""), fileSize)

    private val okHttpClient: OkHttpClient = OkHttpClient()
        .newBuilder()
//        .cache(cache)
        .build()

    private val retrofit: Retrofit = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()


    fun <T> create(clazz: Class<T>): T = retrofit.create(clazz)
}