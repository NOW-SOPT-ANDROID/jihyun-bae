package com.sopt.now.data.datasource.local

import kotlinx.coroutines.flow.Flow

interface SoptLocalDataSource {
    var isLogin: Flow<Boolean>
    suspend fun setIsLogin(isLogin: Boolean)
    var id: Flow<String?>
    suspend fun setId(id: String)
    var password: Flow<String?>
    suspend fun setPassword(password: String)
    var nickname: Flow<String?>
    suspend fun setNickname(nickname: String)
    var mbti: Flow<String?>
    suspend fun setMbti(mbti: String)
    suspend fun clear(): Unit
}