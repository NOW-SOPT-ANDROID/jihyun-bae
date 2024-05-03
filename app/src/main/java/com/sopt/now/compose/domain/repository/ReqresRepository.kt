package com.sopt.now.compose.domain.repository

import com.sopt.now.compose.domain.model.ReqresUserEntity

interface ReqresRepository {
    suspend fun getReqresListUsers(page: Int): Result<List<ReqresUserEntity>>
}