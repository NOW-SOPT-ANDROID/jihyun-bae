package com.sopt.now.domain.repository

import com.sopt.now.domain.model.SoptUserEntity
import com.sopt.now.domain.model.SoptUserInfoEntity

interface SoptAuthRepository {
    suspend fun signIn(authenticationId: String, password: String): Result<Int?>
    suspend fun signUp(soptUserEntity: SoptUserEntity): Result<String>
    suspend fun getUserInfo(memberId: Int): Result<SoptUserInfoEntity?>
}