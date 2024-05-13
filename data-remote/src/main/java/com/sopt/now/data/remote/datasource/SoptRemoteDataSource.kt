package com.sopt.now.data.remote.datasource

import com.sopt.now.data.remote.model.request.RequestSignInDto
import com.sopt.now.data.remote.model.request.RequestSignUpDto
import com.sopt.now.data.remote.model.response.ResponseUserInfoDto
import com.sopt.now.data.remote.model.response.base.BaseResponseDto
import retrofit2.Response

interface SoptRemoteDataSource {
    suspend fun postSignIn(requestSignInDto: RequestSignInDto): Response<BaseResponseDto<Unit>>
    suspend fun postSignUp(requestSignUpDto: RequestSignUpDto): BaseResponseDto<Unit>
    suspend fun getUserInfo(memberId: Int): BaseResponseDto<ResponseUserInfoDto>
}