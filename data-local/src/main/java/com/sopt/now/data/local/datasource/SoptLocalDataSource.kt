package com.sopt.now.data.local.datasource

import com.sopt.now.data.local.model.User
import kotlinx.coroutines.flow.Flow

interface SoptLocalDataSource {
    var isLogin: Flow<Boolean>
    suspend fun setIsLogin(isLogin: Boolean)
    var userId: Flow<Int?>
    suspend fun setUserId(userId: Int)
    suspend fun clear(): Unit
}