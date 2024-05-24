package com.sopt.now.compose.domain.repository

interface SoptRepository {
    fun setIsLogin(isLogin: Boolean)
    fun getIsLogin(): Boolean
    fun setUserId(userId: Int)
    fun getUserId(): Int
    fun clearDataSource()
}