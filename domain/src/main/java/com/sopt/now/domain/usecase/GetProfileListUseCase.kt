package com.sopt.now.domain.usecase

import com.sopt.now.domain.model.ProfileModel
import com.sopt.now.domain.repository.ProfileRepository

class GetProfileListUseCase(
    private val profileRepository: ProfileRepository
) {
    suspend operator fun invoke(): Result<List<ProfileModel>> = profileRepository.getProfileList()
}