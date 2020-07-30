package com.cbsd.investment.http

import com.cbsd.investment.common.HttpConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitManager {


    companion object {
        private var instance: RetrofitManager? = null

        fun getInstance(): RetrofitManager{
            synchronized(this){
                if(instance == null)
                    instance = RetrofitManager()
            }
            return instance!!
        }

    }

    private fun initRetrofit(): Retrofit {
        val okBuilder = OkHttpClient.Builder()
        okBuilder.addInterceptor(HttpLoggingInterceptor())
        okBuilder.callTimeout(20, TimeUnit.SECONDS)
        okBuilder.connectTimeout(20, TimeUnit.SECONDS)
        okBuilder.readTimeout(20, TimeUnit.SECONDS)
        okBuilder.writeTimeout(20, TimeUnit.SECONDS)
        return Retrofit.Builder()
            .baseUrl(HttpConfig.BASE_URL)
            .client(okBuilder.build())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }

    fun <T> api(cls: Class<T>): T {
        return initRetrofit().create(cls)
    }
}