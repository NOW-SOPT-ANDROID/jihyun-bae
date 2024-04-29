package com.sopt.now.compose.data.repository

import com.sopt.now.compose.data.datasource.local.ProfileLocalDataSource
import com.sopt.now.compose.data.mapper.toProfile
import com.sopt.now.compose.data.mapper.toProfileEntity
import com.sopt.now.compose.data.model.local.Profile
import com.sopt.now.compose.domain.model.ProfileEntity
import com.sopt.now.compose.domain.repository.ProfileRepository
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val profileLocalDataSource: ProfileLocalDataSource
) : ProfileRepository {
    override suspend fun getProfileList(): Result<List<ProfileEntity>> = runCatching {
        profileLocalDataSource.getProfileList().map { profile: Profile ->
            profile.toProfileEntity()
        }
    }

    override suspend fun insertProfile(profile: ProfileEntity) {
        profileLocalDataSource.insertProfile(profile = profile.toProfile())
    }

    override suspend fun deleteProfile(profile: ProfileEntity) {
        profileLocalDataSource.deleteProfile(profile = profile.toProfile())
    }
}