package com.sopt.now.domain.usecase

import com.sopt.now.domain.model.ProfileModel
import com.sopt.now.domain.repository.ProfileRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class InsertProfileUseCase @Inject constructor(
    private val profileRepository: ProfileRepository
) {
    suspend operator fun invoke(profile: ProfileModel) =
        profileRepository.insertProfile(profile = profile)
}