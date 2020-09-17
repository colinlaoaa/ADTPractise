package com.liao.adtpractise.view_model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.liao.adtpractise.api.EndPoint
import com.liao.adtpractise.model.AllLocation
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeRepository(private val endpoint:EndPoint) {
    val wholeList: MutableLiveData<AllLocation> by lazy {
        MutableLiveData<AllLocation>()
    }

    fun getListFromApi(page:String) {
        endpoint.getAllList(page).enqueue(object : Callback<AllLocation> {
            override fun onResponse(call: Call<AllLocation>, response: Response<AllLocation>) {
                if (response.body() != null) {
                    wholeList.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<AllLocation>, t: Throwable) {
                Log.d("API", t.message.toString())
            }
        })
    }
}