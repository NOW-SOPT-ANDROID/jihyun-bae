package com.sopt.now.domain.usecase

import com.sopt.now.domain.model.ProfileModel
import com.sopt.now.domain.repository.ProfileRepository

class InsertProfileUseCase(
    private val profileRepository: ProfileRepository
) {
    suspend operator fun invoke(profile: ProfileModel) =
        profileRepository.insertProfile(profile = profile)
}