package com.sopt.now.compose.domain.usecase

import com.sopt.now.compose.domain.model.ProfileEntity
import com.sopt.now.compose.domain.repository.ProfileRepository

class DeleteProfileUseCase(
    private val profileRepository: ProfileRepository
) {
    suspend operator fun invoke(profile: ProfileEntity) =
        profileRepository.deleteProfile(profile = profile)
}