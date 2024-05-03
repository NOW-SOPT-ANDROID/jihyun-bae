package com.sopt.now.compose.data.datasource.remote

import com.sopt.now.compose.data.model.remote.response.ResponseReqresListUsersDto

interface ReqresRemoteDataSource {
    suspend fun getReqresListUsers(page: Int): ResponseReqresListUsersDto
}