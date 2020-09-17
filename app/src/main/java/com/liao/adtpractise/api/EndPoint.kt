package com.liao.adtpractise.api

import com.liao.adtpractise.app.EndPoints
import com.liao.adtpractise.model.AllLocation
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EndPoint {
    @GET(EndPoints.LOCATION)
    fun getAllList(@Query("page") page:String):Call<AllLocation>

    @GET(EndPoints.DETAIL)
    fun getDetail(@Path("id") id:String)
}