package com.sopt.now.compose.domain.usecase

import com.sopt.now.compose.domain.model.ProfileModel
import com.sopt.now.compose.domain.repository.ProfileRepository

class GetProfileListUseCase(
    private val profileRepository: ProfileRepository
) {
    suspend operator fun invoke(): Result<List<ProfileModel>> = profileRepository.getProfileList()
}