package com.sopt.now.compose.data.datasource.remote

import com.sopt.now.compose.data.model.remote.request.RequestSignInDto
import com.sopt.now.compose.data.model.remote.request.RequestSignUpDto
import com.sopt.now.compose.data.model.remote.response.ResponseUserInfoDto
import com.sopt.now.compose.data.model.remote.response.base.BaseResponseDto
import retrofit2.Response

interface SoptRemoteDataSource {
    suspend fun postSignIn(requestSignInDto: RequestSignInDto): String?
    suspend fun postSignUp(requestSignUpDto: RequestSignUpDto): BaseResponseDto<Unit>
    suspend fun getUserInfo(memberId: Int): BaseResponseDto<ResponseUserInfoDto>
}