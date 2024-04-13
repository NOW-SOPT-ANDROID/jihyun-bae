package com.sopt.now.data.datasource.local

import com.sopt.now.data.model.local.User
import kotlinx.coroutines.flow.Flow

interface SoptLocalDataSource {
    var isLogin: Flow<Boolean>
    suspend fun setIsLogin(isLogin: Boolean)
    var user: Flow<User?>
    suspend fun setUser(user: User)
    suspend fun clear(): Unit
}