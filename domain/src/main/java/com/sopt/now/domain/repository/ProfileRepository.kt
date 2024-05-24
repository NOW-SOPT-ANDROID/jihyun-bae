package com.sopt.now.domain.repository

import com.sopt.now.domain.model.ProfileModel

interface ProfileRepository {
    suspend fun getProfileList(): Result<List<ProfileModel>>
    suspend fun insertProfile(profile: ProfileModel)
    suspend fun deleteProfile(profile: ProfileModel)
}