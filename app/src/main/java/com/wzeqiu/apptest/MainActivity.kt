package com.wzeqiu.apptest

import androidx.recyclerview.widget.RecyclerView
import com.wzeqiu.apptest.base.BaseActivity


class MainActivity : BaseActivity<MainPresenter>(), MainControl.MainCallBack {
    

    var rc_history: RecyclerView? = null


    override fun getLayoutId() = R.layout.activity_main

    override fun createPresenter() = MainPresenter(this)

    override fun init() {
        rc_history = this.findViewById(R.id.rc_history)
        presenter?.load()
    }

    override fun loadData() {
    }
}
