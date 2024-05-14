package com.sopt.now.compose.data.repository

import com.sopt.now.compose.data.datasource.local.ProfileLocalDataSource
import com.sopt.now.compose.data.mapper.toProfile
import com.sopt.now.compose.data.mapper.toProfileModel
import com.sopt.now.compose.data.model.local.ProfileEntity
import com.sopt.now.compose.domain.model.ProfileModel
import com.sopt.now.compose.domain.repository.ProfileRepository
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val profileLocalDataSource: ProfileLocalDataSource
) : ProfileRepository {
    override suspend fun getProfiles(): Result<List<ProfileModel>> = runCatching {
        profileLocalDataSource.getProfiles().map { profileEntity: ProfileEntity ->
            profileEntity.toProfileModel()
        }
    }

    override suspend fun insertProfile(profile: ProfileModel) {
        profileLocalDataSource.insertProfile(profileEntity = profile.toProfile())
    }

    override suspend fun deleteProfile(profile: ProfileModel) {
        profileLocalDataSource.deleteProfile(profileEntity = profile.toProfile())
    }
}