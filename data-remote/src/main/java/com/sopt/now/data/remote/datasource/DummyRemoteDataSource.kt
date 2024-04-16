package com.sopt.now.data.remote.datasource

import com.sopt.now.data.remote.model.request.ResponseGetDummyUserListDto

interface DummyRemoteDataSource {
    suspend fun getDummyUserList(page: Int): ResponseGetDummyUserListDto
}