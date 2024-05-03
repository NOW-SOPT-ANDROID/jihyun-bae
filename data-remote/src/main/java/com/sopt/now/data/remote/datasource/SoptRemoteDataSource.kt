package com.sopt.now.data.remote.datasource

import com.sopt.now.data.remote.model.request.RequestSignUpDto
import com.sopt.now.data.remote.model.response.base.BaseResponse

interface SoptRemoteDataSource {
    suspend fun signUp(requestSignUpDto: RequestSignUpDto): BaseResponse
}