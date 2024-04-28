package com.sopt.now.data.local.datasource

import com.sopt.now.data.local.model.Profile

interface ProfileLocalDataSource {
    suspend fun getProfileList(): List<Profile>
    suspend fun insertProfile(profile: Profile)
    suspend fun deleteProfile(profile: Profile)
}