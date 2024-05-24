package com.sopt.now.compose.data.datasource.remote

import com.sopt.now.compose.data.model.remote.response.ResponseReqresUsersDto

interface ReqresRemoteDataSource {
    suspend fun getReqresUsers(page: Int): ResponseReqresUsersDto
}