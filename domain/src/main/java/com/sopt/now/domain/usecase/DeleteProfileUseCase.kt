package com.sopt.now.domain.usecase

import com.sopt.now.domain.model.ProfileModel
import com.sopt.now.domain.repository.ProfileRepository

class DeleteProfileUseCase(
    private val profileRepository: ProfileRepository
) {
    suspend operator fun invoke(profile: ProfileModel) =
        profileRepository.deleteProfile(profile = profile)
}