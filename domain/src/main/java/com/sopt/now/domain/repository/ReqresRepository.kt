package com.sopt.now.domain.repository

import com.sopt.now.domain.model.ReqresUserEntity

interface ReqresRepository {
    suspend fun getReqresListUsers(page: Int): Result<List<ReqresUserEntity>>
}