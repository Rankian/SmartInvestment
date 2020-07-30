package com.cbsd.investment.mvp.preseter

import com.cbsd.investment.http.RetrofitManager

open class BasePresenter<T> {

    fun api(cls: Class<T>): T {
        return RetrofitManager.getInstance().api(cls)
    }
}