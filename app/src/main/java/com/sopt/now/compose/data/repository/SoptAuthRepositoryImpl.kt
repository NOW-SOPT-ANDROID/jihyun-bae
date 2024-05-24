package com.sopt.now.compose.data.repository

import com.sopt.now.compose.data.datasource.remote.SoptRemoteDataSource
import com.sopt.now.compose.data.mapper.toRequestSignUpDto
import com.sopt.now.compose.data.mapper.toSoptUserInfoModel
import com.sopt.now.compose.data.model.remote.request.RequestSignInDto
import com.sopt.now.compose.domain.model.SoptUserModel
import com.sopt.now.compose.domain.model.SoptUserInfoModel
import com.sopt.now.compose.domain.repository.SoptAuthRepository
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
        soptRemoteDataSource.getUserInfo(memberId = memberId).data?.toSoptUserInfoModel()
    }

    companion object {
        const val LOCATION = "Location"
    }
}
