package com.sopt.now.data.repositoryimpl

import com.sopt.now.data.local.datasource.SoptLocalDataSource
import com.sopt.now.domain.repository.SoptRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SoptRepositoryImpl @Inject constructor(
    private val soptLocalDataSource: SoptLocalDataSource
) : SoptRepository {
    override val isLogin: Flow<Boolean> = soptLocalDataSource.isLogin

    override suspend fun setIsLogin(isLogin: Boolean) {
        soptLocalDataSource.setIsLogin(isLogin = isLogin)
    }

    override val userId: Flow<Int?> = soptLocalDataSource.userId

    override suspend fun setUserId(userId: Int) {
        soptLocalDataSource.setUserId(userId = userId)
    }

    override suspend fun clear() {
        soptLocalDataSource.clear()
    }
}