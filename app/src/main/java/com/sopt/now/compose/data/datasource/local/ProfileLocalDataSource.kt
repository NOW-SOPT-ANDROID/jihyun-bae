package com.sopt.now.compose.data.datasource.local

import com.sopt.now.compose.data.model.local.Profile

interface ProfileLocalDataSource {
    suspend fun getProfileList(): List<Profile>
    suspend fun insertProfile(profile: Profile)
    suspend fun deleteProfile(profile: Profile)
}