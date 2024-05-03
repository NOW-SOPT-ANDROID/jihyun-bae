package com.sopt.now.data.remote.datasourceimpl

import com.sopt.now.data.remote.datasource.ReqresRemoteDataSource
import com.sopt.now.data.remote.model.response.ResponseReqresListUsersDto
import com.sopt.now.data.remote.service.ReqresService
import javax.inject.Inject

class ReqresRemoteDataSourceImpl @Inject constructor(
    private val reqresService: ReqresService
) : ReqresRemoteDataSource {
    override suspend fun getReqresListUsers(page: Int): ResponseReqresListUsersDto =
        reqresService.getReqresListUsers(page = page)
}