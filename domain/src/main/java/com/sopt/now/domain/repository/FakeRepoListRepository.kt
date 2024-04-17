package com.sopt.now.domain.repository

import com.sopt.now.domain.model.FakeRepoEntity

interface FakeRepoListRepository {
    suspend fun getFakeRepoList(): Result<List<FakeRepoEntity>>
}