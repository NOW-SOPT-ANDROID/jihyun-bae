package com.sopt.now.data.repositoryimpl

import com.sopt.now.data.mapper.local.toRequestSignUpDto
import com.sopt.now.data.mapper.remote.toSoptUserInfoEntity
import com.sopt.now.data.remote.datasource.SoptRemoteDataSource
import com.sopt.now.data.remote.model.request.RequestSignInDto
import com.sopt.now.domain.model.SoptUserInfoModel
import com.sopt.now.domain.model.SoptUserModel
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
            )?.toInt()
        }

    override suspend fun postSignUp(soptUserModel: SoptUserModel): Result<String> = runCatching {
        soptRemoteDataSource.postSignUp(requestSignUpDto = soptUserModel.toRequestSignUpDto()).message
    }

    override suspend fun getUserInfo(memberId: Int): Result<SoptUserInfoModel?> = runCatching {
        soptRemoteDataSource.getUserInfo(memberId = memberId).data?.toSoptUserInfoEntity()
    }

    companion object {
        const val LOCATION = "Location"
    }
}