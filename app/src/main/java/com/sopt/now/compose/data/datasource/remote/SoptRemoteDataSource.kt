package com.sopt.now.compose.data.datasource.remote

import com.sopt.now.compose.data.model.remote.request.RequestSignInDto
import com.sopt.now.compose.data.model.remote.request.RequestSignUpDto
import com.sopt.now.compose.data.model.remote.response.ResponseUserInfoDto
import com.sopt.now.compose.data.model.remote.response.base.BaseResponse
import retrofit2.Response

interface SoptRemoteDataSource {
    suspend fun signIn(requestSignInDto: RequestSignInDto): Response<BaseResponse<Unit>>
    suspend fun signUp(requestSignUpDto: RequestSignUpDto): BaseResponse<Unit>
    suspend fun getUserInfo(memberId: Int): BaseResponse<ResponseUserInfoDto>
}