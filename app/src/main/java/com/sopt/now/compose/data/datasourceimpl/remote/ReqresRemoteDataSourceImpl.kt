package com.sopt.now.compose.data.datasourceimpl.remote

import com.sopt.now.compose.data.datasource.remote.ReqresRemoteDataSource
import com.sopt.now.compose.data.model.remote.response.ResponseReqresUsersDto
import com.sopt.now.compose.data.service.ReqresService
import javax.inject.Inject

class ReqresRemoteDataSourceImpl @Inject constructor(
    private val reqresService: ReqresService
) : ReqresRemoteDataSource {
    override suspend fun getReqresUsers(page: Int): ResponseReqresUsersDto =
        reqresService.getReqresUsers(page = page)
}