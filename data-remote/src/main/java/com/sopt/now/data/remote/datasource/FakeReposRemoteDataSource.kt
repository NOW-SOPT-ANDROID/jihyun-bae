package com.sopt.now.data.remote.datasource

import com.sopt.now.data.remote.model.response.ResponseFakeReposDto

interface FakeReposRemoteDataSource {
    suspend fun getFakeRepos(): Array<ResponseFakeReposDto>
}