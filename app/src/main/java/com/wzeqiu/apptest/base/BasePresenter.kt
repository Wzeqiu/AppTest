package com.wzeqiu.apptest.base

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.wzeqiu.apptest.http.ResponseBean
import com.wzeqiu.apptest.http.ResponseCallback
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber
import java.lang.Exception

open class BasePresenter<T>(protected var callback: T?) : LifecycleObserver {

    private var compositeDisposable: CompositeDisposable? = CompositeDisposable()

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public fun onStart() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public fun onDestroy() {
        compositeDisposable?.clear()
        compositeDisposable = null
        callback = null

    }


    fun <T> request(observable: Flowable<ResponseBean<T>>, callBack: ResponseCallback<T>) {
        compositeDisposable?.add(
            observable.map(object : Function<ResponseBean<T>, T> {
                override fun apply(t: ResponseBean<T>): T? {
                    if (t.isSuccess()) {
                        return t.result;
                    }
                    throw Exception("失败")
                }

            })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSubscriber<T>() {
                    override fun onComplete() {
                        println("onComplete")
                    }

                    override fun onNext(t: T?) {
                        t?.let { callBack.success(it) }
                        println("onNext>>>" + t)
                    }

                    override fun onError(t: Throwable?) {
                        t?.message?.let { callBack.fail(it) }
                        println("onError >>" + t?.message)
                    }

                })
        )
    }
}