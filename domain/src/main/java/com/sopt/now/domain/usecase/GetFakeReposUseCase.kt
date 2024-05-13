package com.sopt.now.domain.usecase

import com.sopt.now.domain.model.FakeRepoModel
import com.sopt.now.domain.repository.FakeReposRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetFakeReposUseCase @Inject constructor(
    private val fakeReposRepository: FakeReposRepository
) {
    suspend operator fun invoke(): Result<List<FakeRepoModel>> = fakeReposRepository.getFakeRepos()
}