package com.sopt.now.data.remote.service

import com.sopt.now.data.remote.model.request.RequestSignUpDto
import com.sopt.now.data.remote.model.response.ResponseSignUpDto
import retrofit2.http.Body
import retrofit2.http.POST

interface SoptService {
    @POST("member/join")
    suspend fun signUp(
        @Body requestSignUpDto: RequestSignUpDto
    ): ResponseSignUpDto
}