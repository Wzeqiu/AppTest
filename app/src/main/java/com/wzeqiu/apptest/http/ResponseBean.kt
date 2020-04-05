package com.wzeqiu.apptest.http

class ResponseBean<T> {
    var help: String? = null
    var success = false
    var result: T? = null


    fun isSuccess(): Boolean = success


}