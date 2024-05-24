package com.sopt.now.data.remote.datasource

import com.sopt.now.data.remote.model.response.ResponseReqresUsersDto

interface ReqresRemoteDataSource {
    suspend fun getReqresUsers(page: Int): ResponseReqresUsersDto
}