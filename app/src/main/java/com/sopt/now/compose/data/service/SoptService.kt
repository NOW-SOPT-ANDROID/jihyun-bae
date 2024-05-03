package com.sopt.now.compose.data.service

import com.sopt.now.compose.data.model.remote.request.RequestSignInDto
import com.sopt.now.compose.data.model.remote.request.RequestSignUpDto
import com.sopt.now.compose.data.model.remote.response.ResponseUserInfoDto
import com.sopt.now.compose.data.model.remote.response.base.BaseResponse
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