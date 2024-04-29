package com.sopt.now.compose.domain.repository

import com.sopt.now.compose.domain.model.UserEntity

interface SoptRepository {
    fun setIsLogin(isLogin: Boolean)
    fun getIsLogin(): Boolean
    fun setUser(user: UserEntity)
    fun getUser(): UserEntity
    fun clearDataSource()
}