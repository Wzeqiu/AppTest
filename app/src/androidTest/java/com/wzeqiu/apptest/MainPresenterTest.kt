package com.wzeqiu.apptest

import com.wzeqiu.apptest.http.RequestManger
import com.wzeqiu.apptest.http.ResponseCallback
import com.wzeqiu.apptest.http.bean.HistoryBean
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.util.concurrent.CountDownLatch

class MainPresenterTest {

    var mainPresenter = MainPresenter(null)

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun load() {
        var countDownLatch = CountDownLatch(1)
        mainPresenter.request(
            RequestManger.requestInterface.getData(
                14,
                44,
                "a807b7ab-6cad-4aa6-87d0-e283a7353a0f"
            )
            , object : ResponseCallback<HistoryBean> {
                override fun success(data: HistoryBean) {
                    println("test success>>>" + data)
                    countDownLatch.countDown()
                }

                override fun fail(msg: String) {
                    println("test fail>>>" + msg)
                    countDownLatch.countDown()
                }

            })
        countDownLatch.await()

    }
}