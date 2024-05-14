package com.sopt.now.compose.data.datasource.local

import com.sopt.now.compose.data.model.local.ProfileEntity

interface ProfileLocalDataSource {
    suspend fun getProfileList(): List<ProfileEntity>
    suspend fun insertProfile(profileEntity: ProfileEntity)
    suspend fun deleteProfile(profileEntity: ProfileEntity)
}