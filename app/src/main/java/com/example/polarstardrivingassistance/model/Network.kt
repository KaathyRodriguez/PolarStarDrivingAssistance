package com.example.polarstardrivingassistance.model

import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

object Network {

    //mokck 数据请求 url
    private const val baseUrl = ""

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
