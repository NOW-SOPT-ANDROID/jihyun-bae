package com.sopt.now.domain.repository

import com.sopt.now.domain.model.SoptUserEntity
import com.sopt.now.domain.model.SoptUserInfoEntity

interface SoptAuthRepository {
    suspend fun postSignIn(authenticationId: String, password: String): Result<Int?>
    suspend fun postSignUp(soptUserEntity: SoptUserEntity): Result<String>
    suspend fun getUserInfo(memberId: Int): Result<SoptUserInfoEntity?>
}