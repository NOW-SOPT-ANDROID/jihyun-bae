package com.sopt.now.compose.data.repository

import com.sopt.now.compose.data.datasource.remote.SoptRemoteDataSource
import com.sopt.now.compose.data.mapper.toRequestSignUpDto
import com.sopt.now.compose.data.mapper.toSoptUserInfoEntity
import com.sopt.now.compose.data.model.remote.request.RequestSignInDto
import com.sopt.now.compose.domain.model.SoptUserEntity
import com.sopt.now.compose.domain.model.SoptUserInfoEntity
import com.sopt.now.compose.domain.repository.SoptAuthRepository
import javax.inject.Inject

class SoptAuthRepositoryImpl @Inject constructor(
    private val soptRemoteDataSource: SoptRemoteDataSource
) : SoptAuthRepository {
    override suspend fun signIn(authenticationId: String, password: String): Result<Int?> =
        runCatching {
            soptRemoteDataSource.signIn(
                requestSignInDto = RequestSignInDto(
                    authenticationId = authenticationId,
                    password = password
                )
            ).headers()[LOCATION]?.toInt()
        }

    override suspend fun signUp(soptUserEntity: SoptUserEntity): Result<String> = runCatching {
        soptRemoteDataSource.signUp(requestSignUpDto = soptUserEntity.toRequestSignUpDto()).message
    }

    override suspend fun getUserInfo(memberId: Int): Result<SoptUserInfoEntity?> = runCatching {
        soptRemoteDataSource.getUserInfo(memberId = memberId).data?.toSoptUserInfoEntity()
    }

    companion object {
        const val LOCATION = "Location"
    }
}
