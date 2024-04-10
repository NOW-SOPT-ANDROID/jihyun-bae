package com.sopt.now.data.datasource.remote

import com.sopt.now.data.model.remote.request.ResponseGetDummyUserListDto

interface DummyRemoteDataSource {
    suspend fun getDummyUserList(page: Int): ResponseGetDummyUserListDto
}