package com.sopt.now.data.remote.datasource

import com.sopt.now.data.remote.model.response.ResponseFakeRepoListDto

interface FakeRepoListRemoteDataSource {
    suspend fun getFakeRepoList(): Array<ResponseFakeRepoListDto>
}