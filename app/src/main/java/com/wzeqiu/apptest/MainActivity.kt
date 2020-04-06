package com.wzeqiu.apptest

import androidx.recyclerview.widget.LinearLayoutManager
import com.wzeqiu.apptest.adapter.TestAdapter
import com.wzeqiu.apptest.base.BaseActivity
import com.wzeqiu.apptest.bean.QuarterBean
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity<MainPresenter>(), MainControl.MainCallBack {


    private var testAdapter: TestAdapter? = null;

    private var data = mutableListOf<Pair<String, QuarterBean>>()


    override fun getLayoutId() = R.layout.activity_main

    override fun createPresenter() = MainPresenter(this)

    override fun init() {

        rc_history.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        testAdapter = TestAdapter(this, data)
        rc_history.setAdapter(testAdapter)
        rc_history.setHovered(true)
        presenter?.load()

    }


    override fun loadData(data: List<Pair<String, QuarterBean>>) {
        runOnUiThread {
            this.data.addAll(data as MutableList<Pair<String, QuarterBean>>)
            testAdapter?.notifyDataSetChanged()
        }


    }
}
