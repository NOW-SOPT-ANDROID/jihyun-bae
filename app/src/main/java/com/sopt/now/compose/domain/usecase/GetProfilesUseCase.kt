package com.sopt.now.compose.domain.usecase

import com.sopt.now.compose.domain.model.ProfileModel
import com.sopt.now.compose.domain.repository.ProfileRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetProfilesUseCase @Inject constructor(
    private val profileRepository: ProfileRepository
) {
    suspend operator fun invoke(): Result<List<ProfileModel>> = profileRepository.getProfiles()
}