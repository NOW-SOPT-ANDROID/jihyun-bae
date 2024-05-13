package com.sopt.now.domain.usecase

import com.sopt.now.domain.repository.FakeReposRepository

class GetFakeReposUseCase(
    private val fakeReposRepository: FakeReposRepository
) {
    suspend operator fun invoke() = fakeReposRepository.getFakeRepos()
}