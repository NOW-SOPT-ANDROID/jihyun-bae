package com.sopt.now.data.repositoryimpl

import com.sopt.now.data.local.datasource.ProfileLocalDataSource
import com.sopt.now.data.local.model.ProfileEntity
import com.sopt.now.data.mapper.local.toProfile
import com.sopt.now.data.mapper.local.toProfileEntity
import com.sopt.now.domain.model.ProfileModel
import com.sopt.now.domain.repository.ProfileRepository
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val profileLocalDataSource: ProfileLocalDataSource
) : ProfileRepository {
    override suspend fun getProfileList(): Result<List<ProfileModel>> = runCatching {
        profileLocalDataSource.getProfiles().map { profileEntity: ProfileEntity ->
            profileEntity.toProfileEntity()
        }
    }

    override suspend fun insertProfile(profile: ProfileModel) {
        profileLocalDataSource.insertProfile(profileEntity = profile.toProfile())
    }

    override suspend fun deleteProfile(profile: ProfileModel) {
        profileLocalDataSource.deleteProfile(profileEntity = profile.toProfile())
    }
}