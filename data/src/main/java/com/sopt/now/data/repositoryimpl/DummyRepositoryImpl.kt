package com.sopt.now.data.repositoryimpl

import com.sopt.now.data.datasource.remote.DummyRemoteDataSource
import com.sopt.now.domain.model.UserEntity
import com.sopt.now.domain.repository.DummyRepository
import javax.inject.Inject

class DummyRepositoryImpl
@Inject
constructor(
    private val dummyRemoteDataSource: DummyRemoteDataSource
) : DummyRepository {
    override suspend fun getDummyUserList(page: Int): Result<List<UserEntity>> =
        runCatching {
            dummyRemoteDataSource.getDummyUserList(page = page).toUserEntityList()
        }
}