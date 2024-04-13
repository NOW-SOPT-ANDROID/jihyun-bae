package com.sopt.now.data.repositoryimpl

import com.sopt.now.data.datasource.local.SoptLocalDataSource
import com.sopt.now.domain.repository.SoptRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SoptRepositoryImpl @Inject constructor(
    private val soptLocalDataSource: SoptLocalDataSource
) : SoptRepository {
    override var isLogin: Flow<Boolean> = soptLocalDataSource.isLogin

    override suspend fun setIsLogin(isLogin: Boolean) {
        soptLocalDataSource.setIsLogin(isLogin = isLogin)
    }

    override var id: Flow<String?> = soptLocalDataSource.id

    override suspend fun setId(id: String) {
        soptLocalDataSource.setId(id = id)
    }

    override var password: Flow<String?> = soptLocalDataSource.password

    override suspend fun setPassword(password: String) {
        soptLocalDataSource.setPassword(password = password)
    }

    override var nickname: Flow<String?> = soptLocalDataSource.nickname

    override suspend fun setNickname(nickname: String) {
        soptLocalDataSource.setNickname(nickname = nickname)
    }

    override var mbti: Flow<String?> = soptLocalDataSource.mbti

    override suspend fun setMbti(mbti: String) {
        soptLocalDataSource.setMbti(mbti = mbti)
    }

    override suspend fun clear() {
        soptLocalDataSource.clear()
    }
}