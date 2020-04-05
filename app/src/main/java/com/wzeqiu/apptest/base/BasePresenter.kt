package com.wzeqiu.apptest.base

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

open class BasePresenter<T>(callback: T) : LifecycleObserver {
    private var callback: T? = callback

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public fun onStart() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public fun onDestroy() {
        callback = null

    }
}