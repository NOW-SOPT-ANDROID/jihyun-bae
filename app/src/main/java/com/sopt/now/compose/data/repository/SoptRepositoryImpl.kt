package com.sopt.now.compose.data.repository

import com.sopt.now.compose.data.datasource.local.SoptLocalDataSource
import com.sopt.now.compose.domain.repository.SoptRepository
import javax.inject.Inject

class SoptRepositoryImpl @Inject constructor(
    private val soptLocalDataSource: SoptLocalDataSource
) : SoptRepository {
    override fun setIsLogin(isLogin: Boolean) {
        soptLocalDataSource.isLogin = isLogin
    }

    override fun getIsLogin(): Boolean = soptLocalDataSource.isLogin

    override fun setUserId(userId: Int) {
        soptLocalDataSource.userId = userId
    }

    override fun getUserId(): Int = soptLocalDataSource.userId

    override fun clearDataSource() {
        soptLocalDataSource.clear()
    }
}