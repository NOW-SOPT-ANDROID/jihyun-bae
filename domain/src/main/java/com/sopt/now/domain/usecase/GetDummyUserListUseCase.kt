package com.sopt.now.domain.usecase

import com.sopt.now.domain.model.UserEntity
import com.sopt.now.domain.repository.DummyRepository

class GetDummyUserListUseCase(private val dummyRepository: DummyRepository) {
    suspend operator fun invoke(page: Int = 2): Result<List<UserEntity>> =
        dummyRepository.getDummyUserList(page = page)
}