package com.sopt.now.domain.usecase

import com.sopt.now.domain.repository.FakeRepoListRepository

class GetFakeRepoListUseCase(
    private val fakeRepoListRepository: FakeRepoListRepository
) {
    suspend operator fun invoke() = fakeRepoListRepository.getFakeRepoList()
}