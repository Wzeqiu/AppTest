package com.wzeqiu.apptest

import com.wzeqiu.apptest.base.BasePresenter
import com.wzeqiu.apptest.bean.QuarterBean

class MainControl {


    interface MainCallBack {

        fun loadData(data: List<Pair<String, QuarterBean>>)
    }

    abstract class Presenter(callBack: MainCallBack?) : BasePresenter<MainCallBack>(callBack) {


        abstract fun load()


    }

}