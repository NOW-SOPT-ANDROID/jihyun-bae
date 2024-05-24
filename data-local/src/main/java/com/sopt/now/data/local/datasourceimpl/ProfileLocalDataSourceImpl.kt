package com.sopt.now.data.local.datasourceimpl

import com.sopt.now.data.local.database.ProfileDatabase
import com.sopt.now.data.local.datasource.ProfileLocalDataSource
import com.sopt.now.data.local.model.ProfileEntity
import javax.inject.Inject

class ProfileLocalDataSourceImpl @Inject constructor(
 private val profileDatabase: ProfileDatabase
): ProfileLocalDataSource {
    override suspend fun getProfiles(): List<ProfileEntity> = profileDatabase.profileDao().getProfileList()

    override suspend fun insertProfile(profileEntity: ProfileEntity) {
        profileDatabase.profileDao().insertProfile(profileEntity = profileEntity)
    }

    override suspend fun deleteProfile(profileEntity: ProfileEntity) {
        profileDatabase.profileDao().deleteProfile(profileEntity = profileEntity)
    }
}