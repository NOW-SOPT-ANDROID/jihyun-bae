package com.sopt.now.compose.data.repository

import com.sopt.now.compose.data.datasource.local.SoptLocalDataSource
import com.sopt.now.compose.data.mapper.toUser
import com.sopt.now.compose.domain.model.UserEntity
import com.sopt.now.compose.domain.repository.SoptRepository
import javax.inject.Inject

class SoptRepositoryImpl @Inject constructor(
    private val soptLocalDataSource: SoptLocalDataSource
) : SoptRepository {
    override fun setIsLogin(isLogin: Boolean) {
        soptLocalDataSource.isLogin = isLogin
    }

    override fun getIsLogin(): Boolean = soptLocalDataSource.isLogin

    override fun setUser(user: UserEntity) {
        soptLocalDataSource.user = user.toUser()
    }

    override fun getUser(): UserEntity = soptLocalDataSource.user.toUserEntity()

    override fun clearDataSource() {
        soptLocalDataSource.clear()
    }
}