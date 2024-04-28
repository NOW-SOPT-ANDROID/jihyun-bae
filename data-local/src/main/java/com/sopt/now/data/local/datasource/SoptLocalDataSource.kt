package com.sopt.now.data.local.datasource

import com.sopt.now.data.local.model.User
import kotlinx.coroutines.flow.Flow

interface SoptLocalDataSource {
    var isLogin: Flow<Boolean>
    suspend fun setIsLogin(isLogin: Boolean)
    var user: Flow<User?>
    suspend fun setUser(user: User)
    suspend fun clear(): Unit
}