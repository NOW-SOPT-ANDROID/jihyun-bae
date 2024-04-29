package com.sopt.now.compose.domain.repository

import com.sopt.now.compose.domain.model.FakeRepoEntity

interface FakeRepoListRepository {
    suspend fun getFakeRepoList(): Result<List<FakeRepoEntity>>
}