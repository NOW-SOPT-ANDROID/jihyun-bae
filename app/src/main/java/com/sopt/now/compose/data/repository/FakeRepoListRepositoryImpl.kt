package com.sopt.now.compose.data.repository

import com.sopt.now.compose.data.datasource.remote.FakeRepoListRemoteDataSource
import com.sopt.now.compose.data.mapper.toFakeRepoModel
import com.sopt.now.compose.domain.model.FakeRepoModel
import com.sopt.now.compose.domain.repository.FakeRepoListRepository
import javax.inject.Inject

class FakeRepoListRepositoryImpl @Inject constructor(
    private val fakeRepoListRemoteDataSource: FakeRepoListRemoteDataSource
) : FakeRepoListRepository {
    override suspend fun getFakeRepoList(): Result<List<FakeRepoModel>> =
        runCatching {
            fakeRepoListRemoteDataSource.getFakeRepoList().map { responseFakeRepoListDto ->
                responseFakeRepoListDto.toFakeRepoModel()
            }
        }
}