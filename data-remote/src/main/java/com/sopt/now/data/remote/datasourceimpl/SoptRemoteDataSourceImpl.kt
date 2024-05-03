package com.sopt.now.data.remote.datasourceimpl

import com.sopt.now.data.remote.datasource.SoptRemoteDataSource
import com.sopt.now.data.remote.model.request.RequestSignUpDto
import com.sopt.now.data.remote.model.response.base.BaseResponse
import com.sopt.now.data.remote.service.SoptService
import javax.inject.Inject

class SoptRemoteDataSourceImpl @Inject constructor(
    private val soptService: SoptService
) : SoptRemoteDataSource {
    override suspend fun signUp(requestSignUpDto: RequestSignUpDto): BaseResponse<Unit> =
        soptService.signUp(requestSignUpDto = requestSignUpDto)
}