package com.sopt.now.compose.domain.repository

import com.sopt.now.compose.domain.model.SoptUserModel
import com.sopt.now.compose.domain.model.SoptUserInfoModel

interface SoptAuthRepository {
    suspend fun postSignIn(authenticationId: String, password: String): Result<Int?>
    suspend fun postSignUp(soptUserModel: SoptUserModel): Result<String>
    suspend fun getUserInfo(memberId: Int): Result<SoptUserInfoModel?>
}