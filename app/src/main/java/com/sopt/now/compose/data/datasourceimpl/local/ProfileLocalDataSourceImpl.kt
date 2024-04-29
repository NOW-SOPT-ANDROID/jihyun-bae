package com.sopt.now.compose.data.datasourceimpl.local

import com.sopt.now.compose.data.database.database.ProfileDatabase
import com.sopt.now.compose.data.datasource.local.ProfileLocalDataSource
import com.sopt.now.compose.data.model.local.Profile
import javax.inject.Inject

class ProfileLocalDataSourceImpl @Inject constructor(
    private val profileDatabase: ProfileDatabase
) : ProfileLocalDataSource {
    override suspend fun getProfileList(): List<Profile> =
        profileDatabase.profileDao().getProfileList()

    override suspend fun insertProfile(profile: Profile) {
        profileDatabase.profileDao().insertProfile(profile = profile)
    }

    override suspend fun deleteProfile(profile: Profile) {
        profileDatabase.profileDao().deleteProfile(profile = profile)
    }
}