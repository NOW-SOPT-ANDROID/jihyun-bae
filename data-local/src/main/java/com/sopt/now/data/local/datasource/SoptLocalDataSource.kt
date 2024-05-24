package com.sopt.now.data.local.datasource

import kotlinx.coroutines.flow.Flow

interface SoptLocalDataSource {
    val isLogin: Flow<Boolean>
    suspend fun setIsLogin(isLogin: Boolean)
    val userId: Flow<Int?>
    suspend fun setUserId(userId: Int)
    suspend fun clear(): Unit
}