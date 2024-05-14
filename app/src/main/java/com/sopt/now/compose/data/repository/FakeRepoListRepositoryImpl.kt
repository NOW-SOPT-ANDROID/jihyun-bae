package com.sopt.now.compose.data.repository

import com.sopt.now.compose.data.datasource.remote.FakeReposRemoteDataSource
import com.sopt.now.compose.data.mapper.toFakeRepoModel
import com.sopt.now.compose.domain.model.FakeRepoModel
import com.sopt.now.compose.domain.repository.FakeReposRepository
import javax.inject.Inject

class FakeRepoListRepositoryImpl @Inject constructor(
    private val fakeReposRemoteDataSource: FakeReposRemoteDataSource
) : FakeReposRepository {
    override suspend fun getFakeRepos(): Result<List<FakeRepoModel>> =
        runCatching {
            fakeReposRemoteDataSource.getFakeRepos().map { responseFakeRepoListDto ->
                responseFakeRepoListDto.toFakeRepoModel()
            }
        }
}