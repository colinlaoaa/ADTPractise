package com.liao.adtpractise.api

import com.liao.adtpractise.app.Config
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Client {
    private val client: EndPoint by lazy {
        val builder = Retrofit.Builder().baseUrl(Config.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()

        builder.create(EndPoint::class.java)
    }

    fun getClientInstance() = client
}