package com.sopt.now.compose.domain.usecase

import com.sopt.now.compose.domain.model.ProfileModel
import com.sopt.now.compose.domain.repository.ProfileRepository

class DeleteProfileUseCase(
    private val profileRepository: ProfileRepository
) {
    suspend operator fun invoke(profile: ProfileModel) =
        profileRepository.deleteProfile(profile = profile)
}