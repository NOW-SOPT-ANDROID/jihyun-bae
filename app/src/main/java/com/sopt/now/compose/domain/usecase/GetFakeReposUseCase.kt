package com.sopt.now.compose.domain.usecase

import com.sopt.now.compose.domain.repository.FakeReposRepository

class GetFakeReposUseCase(
    private val fakeReposRepository: FakeReposRepository
) {
    suspend operator fun invoke() = fakeReposRepository.getFakeRepos()
}