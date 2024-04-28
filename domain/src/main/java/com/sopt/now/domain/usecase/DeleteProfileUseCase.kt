package com.sopt.now.domain.usecase

import com.sopt.now.domain.model.ProfileEntity
import com.sopt.now.domain.repository.ProfileRepository

class DeleteProfileUseCase(
    private val profileRepository: ProfileRepository
) {
    suspend operator fun invoke(profile: ProfileEntity) =
        profileRepository.deleteProfile(profile = profile)
}