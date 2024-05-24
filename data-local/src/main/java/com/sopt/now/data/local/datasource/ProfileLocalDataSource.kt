package com.sopt.now.data.local.datasource

import com.sopt.now.data.local.model.ProfileEntity

interface ProfileLocalDataSource {
    suspend fun getProfiles(): List<ProfileEntity>
    suspend fun insertProfile(profileEntity: ProfileEntity)
    suspend fun deleteProfile(profileEntity: ProfileEntity)
}