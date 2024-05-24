package com.sopt.now.compose.domain.repository

import com.sopt.now.compose.domain.model.ReqresUserModel

interface ReqresRepository {
    suspend fun getReqresUsers(page: Int): Result<List<ReqresUserModel>>
}