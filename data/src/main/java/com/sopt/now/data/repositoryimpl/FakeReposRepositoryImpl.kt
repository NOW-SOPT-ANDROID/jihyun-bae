package com.sopt.now.data.repositoryimpl

import com.sopt.now.data.mapper.remote.toFakeRepoEntity
import com.sopt.now.data.remote.datasource.FakeReposRemoteDataSource
import com.sopt.now.domain.model.FakeRepoModel
import com.sopt.now.domain.repository.FakeReposRepository
import javax.inject.Inject

class FakeReposRepositoryImpl @Inject constructor(
    private val fakeRepoListRemoteDataSource: FakeReposRemoteDataSource
) : FakeReposRepository {
    override suspend fun getFakeRepos(): Result<List<FakeRepoModel>> =
        runCatching {
            fakeRepoListRemoteDataSource.getFakeRepos().map { responseFakeRepoListDto ->
                responseFakeRepoListDto.toFakeRepoEntity()
            }
        }
}