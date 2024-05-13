package com.sopt.now.data.remote.datasourceimpl

import com.sopt.now.data.remote.datasource.SoptRemoteDataSource
import com.sopt.now.data.remote.model.request.RequestSignInDto
import com.sopt.now.data.remote.model.request.RequestSignUpDto
import com.sopt.now.data.remote.model.response.ResponseUserInfoDto
import com.sopt.now.data.remote.model.response.base.BaseResponseDto
import com.sopt.now.data.remote.service.SoptService
import retrofit2.Response
import javax.inject.Inject

class SoptRemoteDataSourceImpl @Inject constructor(
    private val soptService: SoptService
) : SoptRemoteDataSource {
    override suspend fun postSignIn(requestSignInDto: RequestSignInDto): Response<BaseResponseDto<Unit>> =
        soptService.signIn(requestSignInDto = requestSignInDto)

    override suspend fun postSignUp(requestSignUpDto: RequestSignUpDto): BaseResponseDto<Unit> =
        soptService.signUp(requestSignUpDto = requestSignUpDto)

    override suspend fun getUserInfo(memberId: Int): BaseResponseDto<ResponseUserInfoDto> =
        soptService.getUserInfo(memberId = memberId)
}