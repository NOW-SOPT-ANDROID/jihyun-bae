package com.sopt.now.compose.domain.usecase

import com.sopt.now.compose.domain.model.ProfileEntity
import com.sopt.now.compose.domain.repository.ProfileRepository

class GetProfileListUseCase(
    private val profileRepository: ProfileRepository
) {
    suspend operator fun invoke(): Result<List<ProfileEntity>> = profileRepository.getProfileList()
}