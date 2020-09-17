package com.liao.adtpractise.model

import java.io.Serializable

data class AllLocation(
    val info: Info,
    val results: List<Result>
)

data class Info(
    val count: Int,
    val next: String?,
    val pages: Int,
    val prev: String?
)

data class Result(
    var created: String?=null,
    var dimension: String?=null,
    var id: String?=null,
    var name: String?=null,
    var residents: List<String>?=null,
    var type: String?=null,
    var url: String?=null
):Serializable{
    companion object{
       const val KEY = "key"
    }
}
