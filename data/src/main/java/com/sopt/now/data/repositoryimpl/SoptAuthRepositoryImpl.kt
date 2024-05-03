package com.sopt.now.data.repositoryimpl

import com.sopt.now.data.mapper.local.toRequestSignUpDto
import com.sopt.now.data.remote.datasource.SoptRemoteDataSource
import com.sopt.now.domain.model.SoptUserEntity
import com.sopt.now.domain.repository.SoptAuthRepository
import javax.inject.Inject

class SoptAuthRepositoryImpl @Inject constructor(
    private val soptRemoteDataSource: SoptRemoteDataSource
) : SoptAuthRepository {
    override suspend fun signUp(soptUserEntity: SoptUserEntity): Result<String> = runCatching {
        soptRemoteDataSource.signUp(requestSignUpDto = soptUserEntity.toRequestSignUpDto()).message
    }
}