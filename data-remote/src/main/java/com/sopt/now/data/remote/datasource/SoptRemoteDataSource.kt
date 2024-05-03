package com.sopt.now.data.remote.datasource

import com.sopt.now.data.remote.model.request.RequestSignInDto
import com.sopt.now.data.remote.model.request.RequestSignUpDto
import com.sopt.now.data.remote.model.response.ResponseUserInfoDto
import com.sopt.now.data.remote.model.response.base.BaseResponse
import retrofit2.Response

interface SoptRemoteDataSource {
    suspend fun signIn(requestSignInDto: RequestSignInDto): Response<BaseResponse<Unit>>
    suspend fun signUp(requestSignUpDto: RequestSignUpDto): BaseResponse<Unit>
    suspend fun getUserInfo(memberId: Int): BaseResponse<ResponseUserInfoDto>
}