package com.sopt.now.compose.data.datasource.remote

import com.sopt.now.compose.data.model.remote.response.ResponseFakeRepoListDto

interface FakeRepoListRemoteDataSource {
    suspend fun getFakeRepoList(): Array<ResponseFakeRepoListDto>
}