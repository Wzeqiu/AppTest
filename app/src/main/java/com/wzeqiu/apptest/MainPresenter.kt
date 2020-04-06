package com.wzeqiu.apptest

import com.wzeqiu.apptest.http.RequestManger
import com.wzeqiu.apptest.http.ResponseCallback
import com.wzeqiu.apptest.http.bean.HistoryBean


class MainPresenter(callBack: MainControl.MainCallBack?) : MainControl.Presenter(callBack) {
    override fun load() {

        request(RequestManger.requestInterface.getData(
                14,
                44,
                "a807b7ab-6cad-4aa6-87d0-e283a7353a0f")
            , object :ResponseCallback<HistoryBean>{
                override fun success(data: HistoryBean) {
                    println("success>>>"+data)
                }

                override fun fail(msg: String) {
                    println("fail>>>"+msg)
                }

            }
        )
    }


}