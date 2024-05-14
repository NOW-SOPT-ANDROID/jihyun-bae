package com.sopt.now.compose.domain.repository

import com.sopt.now.compose.domain.model.FakeRepoModel

interface FakeReposRepository {
    suspend fun getFakeRepos(): Result<List<FakeRepoModel>>
}