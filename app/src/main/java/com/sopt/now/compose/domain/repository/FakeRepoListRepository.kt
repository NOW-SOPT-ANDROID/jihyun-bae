package com.sopt.now.compose.domain.repository

import com.sopt.now.compose.domain.model.FakeRepoModel

interface FakeRepoListRepository {
    suspend fun getFakeRepoList(): Result<List<FakeRepoModel>>
}