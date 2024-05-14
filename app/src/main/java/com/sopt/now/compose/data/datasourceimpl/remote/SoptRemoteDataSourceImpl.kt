package com.sopt.now.compose.data.datasourceimpl.remote

import com.sopt.now.compose.data.datasource.remote.SoptRemoteDataSource
import com.sopt.now.compose.data.model.remote.request.RequestSignInDto
import com.sopt.now.compose.data.model.remote.request.RequestSignUpDto
import com.sopt.now.compose.data.model.remote.response.ResponseUserInfoDto
import com.sopt.now.compose.data.model.remote.response.base.BaseResponse
import com.sopt.now.compose.data.service.SoptService
import retrofit2.Response
import javax.inject.Inject

class SoptRemoteDataSourceImpl @Inject constructor(
    private val soptService: SoptService
) : SoptRemoteDataSource {
    override suspend fun postSignIn(requestSignInDto: RequestSignInDto): Response<BaseResponse<Unit>> =
        soptService.signIn(requestSignInDto = requestSignInDto)

    override suspend fun postSignUp(requestSignUpDto: RequestSignUpDto): BaseResponse<Unit> =
        soptService.signUp(requestSignUpDto = requestSignUpDto)

    override suspend fun getUserInfo(memberId: Int): BaseResponse<ResponseUserInfoDto> =
        soptService.getUserInfo(memberId = memberId)
}