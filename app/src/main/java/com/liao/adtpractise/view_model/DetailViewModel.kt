package com.liao.adtpractise.view_model

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.liao.adtpractise.model.Result

class DetailViewModel : ViewModel() {

    var myItem:ObservableField<Result> = ObservableField()

    fun getItemInfo(item:Result){
        myItem.set(item)
    }
}