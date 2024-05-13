package com.sopt.now.data.repositoryimpl

import com.sopt.now.data.mapper.remote.toFakeRepoEntity
import com.sopt.now.data.remote.datasource.FakeRepoListRemoteDataSource
import com.sopt.now.domain.model.FakeRepoModel
import com.sopt.now.domain.repository.FakeRepoListRepository
import javax.inject.Inject

class FakeRepoListRepositoryImpl @Inject constructor(
    private val fakeRepoListRemoteDataSource: FakeRepoListRemoteDataSource
) : FakeRepoListRepository {
    override suspend fun getFakeRepoList(): Result<List<FakeRepoModel>> =
        runCatching {
            fakeRepoListRemoteDataSource.getFakeRepoList().map { responseFakeRepoListDto ->
                responseFakeRepoListDto.toFakeRepoEntity()
            }
        }
}