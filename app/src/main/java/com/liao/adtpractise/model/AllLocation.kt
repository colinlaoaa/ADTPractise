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
    var created: String,
    var dimension: String,
    var id: String,
    var name: String,
    var residents: List<String>,
    var type: String,
    var url: String
):Serializable{
    companion object{
       const val KEY = "key"
    }
}
