package com.sopt.now.domain.repository

import com.sopt.now.domain.model.FakeRepoModel

interface FakeRepoListRepository {
    suspend fun getFakeRepoList(): Result<List<FakeRepoModel>>
}