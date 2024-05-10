package com.sopt.now.domain.repository

import kotlinx.coroutines.flow.Flow

interface SoptRepository {
    val isLogin: Flow<Boolean>
    suspend fun setIsLogin(isLogin: Boolean)
    val userId: Flow<Int?>
    suspend fun setUserId(userId: Int)
    suspend fun clear(): Unit
}