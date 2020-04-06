package com.wzeqiu.apptest.http


interface ResponseCallback<T> {
    fun success(data: T)

    fun fail(msg:String)
}