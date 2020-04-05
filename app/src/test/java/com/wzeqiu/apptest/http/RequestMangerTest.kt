package com.wzeqiu.apptest.http

import com.wzeqiu.apptest.http.bean.HistoryBean
import io.reactivex.schedulers.Schedulers
import org.junit.After
import org.junit.Before

import org.junit.Test
import  io.reactivex.functions.Function
import io.reactivex.subscribers.DisposableSubscriber
import java.lang.Exception
import java.util.concurrent.CountDownLatch

class RequestMangerTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }


    @Test
    fun jvmQuestTest() {
        //https://data.gov.sg/api/action/datastore_search?offset=14&limit=44&resource_id=a807b7ab-6cad-4aa6-87d0-e283a7353a0f
        var countDownLatch = CountDownLatch(1)
        RequestManger.requestInterface.getData(14, 44, "a807b7ab-6cad-4aa6-87d0-e283a7353a0f")
            .map(object : Function<ResponseBean<HistoryBean>, HistoryBean> {
                override fun apply(t: ResponseBean<HistoryBean>): HistoryBean? {
                    if (t.isSuccess()) {
                        return t.result;
                    }
                    throw Exception("失败")
                }

            })
            .subscribeOn(Schedulers.io())
            .subscribeWith(object : DisposableSubscriber<HistoryBean>() {
                override fun onComplete() {
                    countDownLatch.countDown()
                    println("onComplete")
                }

                override fun onNext(t: HistoryBean?) {
                    countDownLatch.countDown()
                    println("onNext>>>" + t)
                }

                override fun onError(t: Throwable?) {
                    countDownLatch.countDown()
                    println("onError >>" + t?.message)
                }

            })
        countDownLatch.await()
    }
}