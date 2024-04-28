package com.sopt.now.domain.repository

import com.sopt.now.domain.model.ProfileEntity

interface ProfileRepository {
    suspend fun getProfileList(): Result<List<ProfileEntity>>
    suspend fun insertProfile(profile: ProfileEntity)
    suspend fun deleteProfile(profile: ProfileEntity)
}