package com.wzeqiu.apptest

import com.wzeqiu.apptest.bean.QuarterBean
import com.wzeqiu.apptest.http.RequestManger
import com.wzeqiu.apptest.http.ResponseCallback
import com.wzeqiu.apptest.http.bean.HistoryBean
import java.math.BigDecimal
import java.util.*


class MainPresenter(callBack: MainControl.MainCallBack?) : MainControl.Presenter(callBack) {
    override fun load() {

        request(RequestManger.requestInterface.getData(
            14,
            44,
            "a807b7ab-6cad-4aa6-87d0-e283a7353a0f"
        )
            , object : ResponseCallback<HistoryBean> {
                override fun success(data: HistoryBean) {


                    var hashMap = TreeMap<String, QuarterBean>()
                    data.records?.forEach {
                        var key = it.quarter!!.split("-")
                        var quarterBean = hashMap.get(key[0])
                        if (quarterBean == null) {
                            quarterBean = QuarterBean()
                        }
                        when (key[1]) {
                            "Q1" -> quarterBean.Q1 = BigDecimal(it.volume_of_mobile_data)
                            "Q2" -> quarterBean.Q2 = BigDecimal(it.volume_of_mobile_data)
                            "Q3" -> quarterBean.Q3 = BigDecimal(it.volume_of_mobile_data)
                            "Q4" -> quarterBean.Q4 = BigDecimal(it.volume_of_mobile_data)
                        }
                        quarterBean.total =
                            quarterBean.total.add(BigDecimal(it.volume_of_mobile_data))

                        quarterBean.decline = quarterBean.Q1 > quarterBean.Q2 ||
                                quarterBean.Q1 > quarterBean.Q3 ||
                                quarterBean.Q1 > quarterBean.Q4 ||
                                quarterBean.Q2 > quarterBean.Q3 ||
                                quarterBean.Q2 > quarterBean.Q4 ||
                                quarterBean.Q3 > quarterBean.Q4

                        hashMap.put(key[0], quarterBean)
                    }

                    callback?.loadData(hashMap.toList())
                    println("success>>>" + data)
                }

                override fun fail(msg: String) {
                    println("fail>>>" + msg)
                }

            }
        )
    }


}