package com.sopt.now.data.remote.service

import com.sopt.now.data.remote.model.request.RequestSignInDto
import com.sopt.now.data.remote.model.request.RequestSignUpDto
import com.sopt.now.data.remote.model.response.ResponseUserInfoDto
import com.sopt.now.data.remote.model.response.base.BaseResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface SoptService {
    @POST("member/login")
    suspend fun signIn(
        @Body requestSignInDto: RequestSignInDto
    ): Response<BaseResponse<Unit>>

    @POST("member/join")
    suspend fun signUp(
        @Body requestSignUpDto: RequestSignUpDto
    ): BaseResponse<Unit>

    @GET("member/info")
    suspend fun getUserInfo(
        @Header("memberId") memberId: Int
    ): BaseResponse<ResponseUserInfoDto>
}