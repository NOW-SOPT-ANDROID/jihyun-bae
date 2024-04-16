package com.sopt.now.data.repositoryimpl

import com.sopt.now.data.local.datasource.ProfileLocalDataSource
import com.sopt.now.data.local.model.Profile
import com.sopt.now.domain.model.ProfileEntity
import com.sopt.now.domain.repository.ProfileRepository
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
        TODO("Not yet implemented")
    }

    override suspend fun deleteProfile(profile: ProfileEntity) {
        TODO("Not yet implemented")
    }
}