package com.sopt.now.data.remote.service

import com.sopt.now.data.remote.model.response.ResponseReqresListUsersDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ReqresService {
    @GET("api/users")
    suspend fun getReqresListUsers(
        @Query("page") page: Int
    ): ResponseReqresListUsersDto
}