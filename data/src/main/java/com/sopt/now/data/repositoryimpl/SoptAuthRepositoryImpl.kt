package com.sopt.now.data.repositoryimpl

import com.sopt.now.data.mapper.local.toRequestSignUpDto
import com.sopt.now.data.mapper.local.toSoptUserInfoEntity
import com.sopt.now.data.remote.datasource.SoptRemoteDataSource
import com.sopt.now.data.remote.model.request.RequestSignInDto
import com.sopt.now.domain.model.SoptUserEntity
import com.sopt.now.domain.model.SoptUserInfoEntity
import com.sopt.now.domain.repository.SoptAuthRepository
import javax.inject.Inject

class SoptAuthRepositoryImpl @Inject constructor(
    private val soptRemoteDataSource: SoptRemoteDataSource
) : SoptAuthRepository {
    override suspend fun postSignIn(authenticationId: String, password: String): Result<Int?> =
        runCatching {
            soptRemoteDataSource.postSignIn(
                requestSignInDto = RequestSignInDto(
                    authenticationId = authenticationId,
                    password = password
                )
            ).headers()[LOCATION]?.toInt()
        }

    override suspend fun postSignUp(soptUserEntity: SoptUserEntity): Result<String> = runCatching {
        soptRemoteDataSource.postSignUp(requestSignUpDto = soptUserEntity.toRequestSignUpDto()).message
    }

    override suspend fun getUserInfo(memberId: Int): Result<SoptUserInfoEntity?> = runCatching {
        soptRemoteDataSource.getUserInfo(memberId = memberId).data?.toSoptUserInfoEntity()
    }

    companion object {
        const val LOCATION = "Location"
    }
}