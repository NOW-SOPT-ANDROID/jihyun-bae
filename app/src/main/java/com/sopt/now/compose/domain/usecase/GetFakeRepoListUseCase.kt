package com.sopt.now.compose.domain.usecase

import com.sopt.now.compose.domain.repository.FakeRepoListRepository

class GetFakeRepoListUseCase(
    private val fakeRepoListRepository: FakeRepoListRepository
) {
    suspend operator fun invoke() = fakeRepoListRepository.getFakeRepoList()
}