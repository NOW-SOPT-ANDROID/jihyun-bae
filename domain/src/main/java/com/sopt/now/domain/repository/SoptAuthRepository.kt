package com.sopt.now.domain.repository

import com.sopt.now.domain.model.SoptUserEntity

interface SoptAuthRepository {
    suspend fun signUp(soptUserEntity: SoptUserEntity): Result<String>
}