package com.liao.adtpractise.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.liao.adtpractise.api.Client
import com.liao.adtpractise.model.Result

class HomeViewModel : ViewModel() {
    private val homeRepository = HomeRepository(Client.getClientInstance())

    private val detailClicked:MutableLiveData<Result> by lazy {
        MutableLiveData<Result>()
    }


    fun callAPIGetList(page: String) {
        homeRepository.getListFromApi(page)
    }

    fun observeLiveDate() = homeRepository.wholeList


    fun getItemDetail(item: Result) {
        detailClicked.postValue(item)
    }

    fun observeItemClicked() = detailClicked
}