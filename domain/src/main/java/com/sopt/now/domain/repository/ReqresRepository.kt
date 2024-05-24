package com.sopt.now.domain.repository

import com.sopt.now.domain.model.ReqresUserModel

interface ReqresRepository {
    suspend fun getReqresListUsers(page: Int): Result<List<ReqresUserModel>>
}