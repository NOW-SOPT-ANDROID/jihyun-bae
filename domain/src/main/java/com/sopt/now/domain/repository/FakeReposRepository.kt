package com.sopt.now.domain.repository

import com.sopt.now.domain.model.FakeRepoModel

interface FakeReposRepository {
    suspend fun getFakeRepos(): Result<List<FakeRepoModel>>
}