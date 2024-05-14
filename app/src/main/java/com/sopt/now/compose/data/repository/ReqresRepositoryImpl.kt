package com.sopt.now.compose.data.repository

import com.sopt.now.compose.data.datasource.remote.ReqresRemoteDataSource
import com.sopt.now.compose.data.mapper.toReqresUserModel
import com.sopt.now.compose.data.model.remote.response.ResponseReqresListUsersDto
import com.sopt.now.compose.domain.model.ReqresUserModel
import com.sopt.now.compose.domain.repository.ReqresRepository
import javax.inject.Inject

class ReqresRepositoryImpl @Inject constructor(
    private val reqresRemoteDataSource: ReqresRemoteDataSource
) : ReqresRepository {
    override suspend fun getReqresListUsers(page: Int): Result<List<ReqresUserModel>> =
        runCatching {
            reqresRemoteDataSource.getReqresListUsers(page = page).data.map { responseUserDto: ResponseReqresListUsersDto.ResponseUserDto ->
                responseUserDto.toReqresUserModel()
            }
        }
}