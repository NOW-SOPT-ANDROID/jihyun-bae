package com.sopt.now.compose.data.service

import com.sopt.now.compose.data.model.remote.response.ResponseReqresUsersDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ReqresService {
    @GET("api/users")
    suspend fun getReqresUsers(
        @Query("page") page: Int
    ): ResponseReqresUsersDto
}