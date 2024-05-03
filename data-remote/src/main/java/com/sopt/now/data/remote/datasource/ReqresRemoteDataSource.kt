package com.sopt.now.data.remote.datasource

import com.sopt.now.data.remote.model.response.ResponseReqresListUsersDto

interface ReqresRemoteDataSource {
    suspend fun getReqresListUsers(page: Int): ResponseReqresListUsersDto
}