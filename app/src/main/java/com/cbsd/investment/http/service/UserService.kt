package com.cbsd.investment.http.service

import com.cbsd.investment.common.HttpConfig
import io.reactivex.rxjava3.core.Observable
import org.json.JSONObject
import retrofit2.http.POST

interface UserService {

    @POST(HttpConfig.API_LOGIN)
    fun login(): Observable<JSONObject>
}