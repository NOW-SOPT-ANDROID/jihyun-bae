package com.sopt.now.compose.domain.repository

import com.sopt.now.compose.domain.model.ProfileEntity

interface ProfileRepository {
    suspend fun getProfileList(): Result<List<ProfileEntity>>
    suspend fun insertProfile(profile: ProfileEntity)
    suspend fun deleteProfile(profile: ProfileEntity)
}