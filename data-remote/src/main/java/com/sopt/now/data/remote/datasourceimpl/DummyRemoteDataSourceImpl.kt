package com.sopt.now.data.remote.datasourceimpl

import com.sopt.now.data.datasource.remote.DummyRemoteDataSource
import com.sopt.now.data.model.remote.request.ResponseGetDummyUserListDto
import com.sopt.now.data.remote.service.DummyService
import javax.inject.Inject

class DummyRemoteDataSourceImpl
@Inject
constructor(
    private val dummyService: DummyService
) : DummyRemoteDataSource {
    override suspend fun getDummyUserList(page: Int): ResponseGetDummyUserListDto =
        dummyService.getDummyListUserList(page = page)
}