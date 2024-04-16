package com.sopt.now.data.remote.service

import com.sopt.now.data.remote.model.request.ResponseGetDummyUserListDto
import retrofit2.http.GET
import retrofit2.http.Query

interface DummyService {
    @GET("$API/$USERS")
    suspend fun getDummyListUserList(
        @Query("page") page: Int
    ): ResponseGetDummyUserListDto

    companion object {
        const val API = "api"
        const val USERS = "users"
    }
}