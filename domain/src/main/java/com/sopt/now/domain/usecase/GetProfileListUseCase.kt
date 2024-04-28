package com.sopt.now.domain.usecase

import com.sopt.now.domain.model.ProfileEntity
import com.sopt.now.domain.repository.ProfileRepository

class GetProfileListUseCase(
    private val profileRepository: ProfileRepository
) {
    suspend operator fun invoke(): Result<List<ProfileEntity>> = profileRepository.getProfileList()
}