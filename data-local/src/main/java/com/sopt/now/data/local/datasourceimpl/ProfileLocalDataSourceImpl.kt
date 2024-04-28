package com.sopt.now.data.local.datasourceimpl

import com.sopt.now.data.local.database.ProfileDatabase
import com.sopt.now.data.local.datasource.ProfileLocalDataSource
import com.sopt.now.data.local.model.Profile
import javax.inject.Inject

class ProfileLocalDataSourceImpl @Inject constructor(
 private val profileDatabase: ProfileDatabase
): ProfileLocalDataSource {
    override suspend fun getProfileList(): List<Profile> = profileDatabase.profileDao().getProfileList()

    override suspend fun insertProfile(profile: Profile) {
        profileDatabase.profileDao().insertProfile(profile = profile)
    }

    override suspend fun deleteProfile(profile: Profile) {
        profileDatabase.profileDao().deleteProfile(profile = profile)
    }
}