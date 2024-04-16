package com.sopt.now.data.repositoryimpl

import com.sopt.now.data.local.datasource.SoptLocalDataSource
import com.sopt.now.data.mapper.local.toUser
import com.sopt.now.domain.model.UserEntity
import com.sopt.now.domain.repository.SoptRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SoptRepositoryImpl @Inject constructor(
    private val soptLocalDataSource: SoptLocalDataSource
) : SoptRepository {
    override var isLogin: Flow<Boolean> = soptLocalDataSource.isLogin

    override suspend fun setIsLogin(isLogin: Boolean) {
        soptLocalDataSource.setIsLogin(isLogin = isLogin)
    }

    override var user: Flow<UserEntity?> = soptLocalDataSource.user.map { user ->
        user?.toUserEntity()
    }

    override suspend fun setUser(userEntity: UserEntity) {
        soptLocalDataSource.setUser(user = userEntity.toUser())
    }

    override suspend fun clear() {
        soptLocalDataSource.clear()
    }
}