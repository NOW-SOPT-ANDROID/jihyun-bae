package com.sopt.now.compose.data.repository

import com.sopt.now.compose.data.datasource.remote.FakeRepoListRemoteDataSource
import com.sopt.now.compose.data.mapper.toFakeRepoEntity
import com.sopt.now.compose.domain.model.FakeRepoEntity
import com.sopt.now.compose.domain.repository.FakeRepoListRepository
import javax.inject.Inject

class FakeRepoListRepositoryImpl @Inject constructor(
    private val fakeRepoListRemoteDataSource: FakeRepoListRemoteDataSource
) : FakeRepoListRepository {
    override suspend fun getFakeRepoList(): Result<List<FakeRepoEntity>> =
        runCatching {
            fakeRepoListRemoteDataSource.getFakeRepoList().map { responseFakeRepoListDto ->
                responseFakeRepoListDto.toFakeRepoEntity()
            }
        }
}