package com.wzeqiu.apptest

import com.wzeqiu.apptest.base.BasePresenter

class MainControl {


    interface MainCallBack  {

        fun  loadData()
    }

    abstract class Presenter(callBack: MainCallBack?) : BasePresenter<MainCallBack>(callBack) {


        abstract fun load()


    }

}