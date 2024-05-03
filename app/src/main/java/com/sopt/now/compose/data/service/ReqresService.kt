package com.sopt.now.compose.data.service

import com.sopt.now.compose.data.model.remote.response.ResponseReqresListUsersDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ReqresService {
    @GET("api/users")
    suspend fun getReqresListUsers(
        @Query("page") page: Int
    ): ResponseReqresListUsersDto
}