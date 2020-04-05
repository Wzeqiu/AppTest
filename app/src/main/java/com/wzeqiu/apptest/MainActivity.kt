package com.wzeqiu.apptest

import com.wzeqiu.apptest.base.BaseActivity
import com.wzeqiu.apptest.base.BasePresenter


class MainActivity : BaseActivity<BasePresenter<*>>() {

    override fun getLayoutId() = R.layout.activity_main


    override fun init() {
    }
}
