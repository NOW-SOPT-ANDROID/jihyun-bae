package com.sopt.now.compose.di

import com.sopt.now.compose.domain.repository.FakeReposRepository
import com.sopt.now.compose.domain.repository.ProfileRepository
import com.sopt.now.compose.domain.repository.ReqresRepository
import com.sopt.now.compose.domain.repository.SoptAuthRepository
import com.sopt.now.compose.domain.repository.SoptRepository
import com.sopt.now.compose.domain.usecase.ClearDataSourceUseCase
import com.sopt.now.compose.domain.usecase.DeleteProfileUseCase
import com.sopt.now.compose.domain.usecase.GetFakeReposUseCase
import com.sopt.now.compose.domain.usecase.GetIsLoginUseCase
import com.sopt.now.compose.domain.usecase.GetProfilesUseCase
import com.sopt.now.compose.domain.usecase.GetReqresUsersUseCase
import com.sopt.now.compose.domain.usecase.GetUserInfoUseCase
import com.sopt.now.compose.domain.usecase.GetUserIdUseCase
import com.sopt.now.compose.domain.usecase.InsertProfileUseCase
import com.sopt.now.compose.domain.usecase.PostSignInUseCase
import com.sopt.now.compose.domain.usecase.PostSignUpUseCase
import com.sopt.now.compose.domain.usecase.SetIsLoginUseCase
import com.sopt.now.compose.domain.usecase.SetUserIdUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Provides
    @Singleton
    fun providesClearDataSourceUseCase(soptRepository: SoptRepository): ClearDataSourceUseCase =
        ClearDataSourceUseCase(soptRepository = soptRepository)

    @Provides
    @Singleton
    fun providesDeleteProfileUseCase(profileRepository: ProfileRepository): DeleteProfileUseCase =
        DeleteProfileUseCase(profileRepository = profileRepository)

    @Provides
    @Singleton
    fun providesGetFakeRepoListUseCase(fakeReposRepository: FakeReposRepository) =
        GetFakeReposUseCase(fakeReposRepository = fakeReposRepository)

    @Provides
    @Singleton
    fun providesGetIsLoginUseCase(soptRepository: SoptRepository): GetIsLoginUseCase =
        GetIsLoginUseCase(soptRepository = soptRepository)

    @Provides
    @Singleton
    fun providesGetProfileListUseCase(profileRepository: ProfileRepository): GetProfilesUseCase =
        GetProfilesUseCase(profileRepository = profileRepository)

    @Provides
    @Singleton
    fun providesGetReqresListUserUseCase(reqresRepository: ReqresRepository): GetReqresUsersUseCase =
        GetReqresUsersUseCase(reqresRepository = reqresRepository)

    @Provides
    @Singleton
    fun providesGetUserInfoUseCase(soptAuthRepository: SoptAuthRepository): GetUserInfoUseCase =
        GetUserInfoUseCase(soptAuthRepository = soptAuthRepository)

    @Provides
    @Singleton
    fun providesGetUserIdUseCase(soptRepository: SoptRepository): GetUserIdUseCase =
        GetUserIdUseCase(soptRepository = soptRepository)

    @Provides
    @Singleton
    fun providesInsertProfileUseCase(profileRepository: ProfileRepository): InsertProfileUseCase =
        InsertProfileUseCase(profileRepository = profileRepository)

    @Provides
    @Singleton
    fun providesPostSignInUseCase(soptAuthRepository: SoptAuthRepository): PostSignInUseCase =
        PostSignInUseCase(soptAuthRepository = soptAuthRepository)

    @Provides
    @Singleton
    fun providesPostSignUpUseCase(soptAuthRepository: SoptAuthRepository): PostSignUpUseCase =
        PostSignUpUseCase(soptAuthRepository = soptAuthRepository)

    @Provides
    @Singleton
    fun providesSetIsLoginUseCase(soptRepository: SoptRepository): SetIsLoginUseCase =
        SetIsLoginUseCase(soptRepository = soptRepository)

    @Provides
    @Singleton
    fun providesSetUserIdUseCase(soptRepository: SoptRepository): SetUserIdUseCase =
        SetUserIdUseCase(soptRepository = soptRepository)
}