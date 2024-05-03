package com.sopt.now.data.remote.datasource

import com.sopt.now.data.remote.model.request.RequestSignUpDto
import com.sopt.now.data.remote.model.response.ResponseSignUpDto

interface SoptRemoteDataSource {
    suspend fun signUp(requestSignUpDto: RequestSignUpDto): ResponseSignUpDto
}