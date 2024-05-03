package com.sopt.now.domain.repository

import com.sopt.now.domain.model.UserEntity
import kotlinx.coroutines.flow.Flow

interface SoptRepository {
    var isLogin: Flow<Boolean>
    suspend fun setIsLogin(isLogin: Boolean)
    var userId: Flow<Int?>
    suspend fun setUserId(userId: Int)
    suspend fun clear(): Unit
}