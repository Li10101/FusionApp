package com.fusion.data

import com.google.gson.annotations.SerializedName
// 通用响应体（根据实际API调整）
data class BaseResponse<T>(
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: T,
    @SerializedName("timestamp") val timestamp : Long
)
