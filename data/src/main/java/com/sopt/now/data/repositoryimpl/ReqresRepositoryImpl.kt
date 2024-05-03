package com.sopt.now.data.repositoryimpl

import com.sopt.now.data.mapper.local.toReqresUserEntity
import com.sopt.now.data.remote.datasource.ReqresRemoteDataSource
import com.sopt.now.data.remote.model.response.ResponseReqresListUsersDto
import com.sopt.now.domain.model.ReqresUserEntity
import com.sopt.now.domain.repository.ReqresRepository
import javax.inject.Inject

class ReqresRepositoryImpl @Inject constructor(
    private val reqresRemoteDataSource: ReqresRemoteDataSource
) : ReqresRepository {
    override suspend fun getReqresListUsers(page: Int): Result<List<ReqresUserEntity>> =
        runCatching {
            reqresRemoteDataSource.getReqresListUsers(page = page).data.map { user: ResponseReqresListUsersDto.User ->
                user.toReqresUserEntity()
            }
        }
}