package com.example.polarstardrivingassistance.model

import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object Network {

    //mokck 数据请求 url
    private const val baseUrl = "https://console-mock.apipost.cn/mock/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(
            MoshiConverterFactory.create(
                Moshi.Builder()
                    .add(com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory())
                    .build()
            )
        )
        .build()

    fun <T> createService(clazz: Class<T>): T {
        return retrofit.create(clazz)
    }
}
