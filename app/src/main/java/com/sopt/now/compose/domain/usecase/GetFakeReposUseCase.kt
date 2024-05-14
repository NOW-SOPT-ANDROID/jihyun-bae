package com.sopt.now.compose.domain.usecase

import com.sopt.now.compose.domain.repository.FakeReposRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetFakeReposUseCase @Inject constructor(
    private val fakeReposRepository: FakeReposRepository
) {
    suspend operator fun invoke() = fakeReposRepository.getFakeRepos()
}