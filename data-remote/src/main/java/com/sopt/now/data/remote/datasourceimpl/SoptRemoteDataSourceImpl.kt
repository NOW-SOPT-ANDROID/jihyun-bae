package com.sopt.now.data.remote.datasourceimpl

import com.sopt.now.data.remote.datasource.SoptRemoteDataSource
import com.sopt.now.data.remote.model.request.RequestSignUpDto
import com.sopt.now.data.remote.model.response.ResponseSignUpDto
import com.sopt.now.data.remote.service.SoptService
import javax.inject.Inject

class SoptRemoteDataSourceImpl @Inject constructor(
    private val soptService: SoptService
) : SoptRemoteDataSource {
    override suspend fun signUp(requestSignUpDto: RequestSignUpDto): ResponseSignUpDto =
        soptService.signUp(requestSignUpDto = requestSignUpDto)
}