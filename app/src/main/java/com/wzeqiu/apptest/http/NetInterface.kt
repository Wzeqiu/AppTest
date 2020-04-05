package com.wzeqiu.apptest.http

import com.wzeqiu.apptest.http.bean.HistoryBean
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface NetInterface {
    @GET("api/action/datastore_search?")
    fun getData(@Query("offset") offset: Int, @Query("limit") limit: Int, @Query("resource_id") resource_id: String): Flowable<ResponseBean<HistoryBean>>
}