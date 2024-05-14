package com.sopt.now.compose.data.datasource.remote

import com.sopt.now.compose.data.model.remote.response.ResponseFakeReposDto

interface FakeReposRemoteDataSource {
    suspend fun getFakeRepos(): Array<ResponseFakeReposDto>
}