package com.wzeqiu.apptest.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<P : BasePresenter<*>> : AppCompatActivity() {
    protected var presenter: P? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())

        this.presenter = createPresenter()
        if (presenter != null) {
            lifecycle.addObserver(presenter!!)
        }

        init()
    }

    open fun createPresenter(): P? = null

    public abstract fun getLayoutId(): Int

    public abstract fun init()


    override fun onDestroy() {
        super.onDestroy()
        if (presenter != null) {
            lifecycle.removeObserver(presenter!!)
        }
    }


}