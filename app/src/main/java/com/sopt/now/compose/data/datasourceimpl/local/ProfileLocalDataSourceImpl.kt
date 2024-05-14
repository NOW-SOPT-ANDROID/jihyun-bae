package com.sopt.now.compose.data.datasourceimpl.local

import com.sopt.now.compose.data.database.database.ProfileDatabase
import com.sopt.now.compose.data.datasource.local.ProfileLocalDataSource
import com.sopt.now.compose.data.model.local.ProfileEntity
import javax.inject.Inject

class ProfileLocalDataSourceImpl @Inject constructor(
    private val profileDatabase: ProfileDatabase
) : ProfileLocalDataSource {
    override suspend fun getProfiles(): List<ProfileEntity> =
        profileDatabase.profileDao().getProfileList()

    override suspend fun insertProfile(profileEntity: ProfileEntity) {
        profileDatabase.profileDao().insertProfile(profileEntity = profileEntity)
    }

    override suspend fun deleteProfile(profileEntity: ProfileEntity) {
        profileDatabase.profileDao().deleteProfile(profileEntity = profileEntity)
    }
}