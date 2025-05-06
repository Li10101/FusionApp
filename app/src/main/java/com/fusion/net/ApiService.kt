package com.fusion.net

import com.fusion.data.BaseResponse
import com.fusion.data.LoginRequest
import com.fusion.data.LoginResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @POST("user/login")
    fun login(
        @Body request: LoginRequest
    ): Observable<BaseResponse<LoginResponse>>

    @Headers("Content-Type: application/json")
    @POST("/auth/app/login")
    fun login(
        @Body params: String
    ): Observable<BaseResponse<LoginResponse>>

}