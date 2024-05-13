package com.sopt.now.di

import com.sopt.now.domain.repository.FakeReposRepository
import com.sopt.now.domain.repository.ProfileRepository
import com.sopt.now.domain.repository.ReqresRepository
import com.sopt.now.domain.repository.SoptAuthRepository
import com.sopt.now.domain.usecase.DeleteProfileUseCase
import com.sopt.now.domain.usecase.GetFakeReposUseCase
import com.sopt.now.domain.usecase.GetProfileListUseCase
import com.sopt.now.domain.usecase.GetReqresListUsersUseCase
import com.sopt.now.domain.usecase.GetUserInfoUseCase
import com.sopt.now.domain.usecase.InsertProfileUseCase
import com.sopt.now.domain.usecase.PostSignInUseCase
import com.sopt.now.domain.usecase.PostSignUpUseCase
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
    fun providesDeleteProfileUseCase(profileRepository: ProfileRepository): DeleteProfileUseCase =
        DeleteProfileUseCase(profileRepository = profileRepository)

    @Provides
    @Singleton
    fun providesGetFakeReposUseCase(fakeReposRepository: FakeReposRepository): GetFakeReposUseCase =
        GetFakeReposUseCase(fakeReposRepository = fakeReposRepository)

    @Provides
    @Singleton
    fun providesGetProfileListUseCase(profileRepository: ProfileRepository): GetProfileListUseCase =
        GetProfileListUseCase(profileRepository = profileRepository)

    @Provides
    @Singleton
    fun providesGetReqresListUserUseCase(reqresRepository: ReqresRepository): GetReqresListUsersUseCase =
        GetReqresListUsersUseCase(reqresRepository = reqresRepository)

    @Provides
    @Singleton
    fun providesGetUserInfoUseCase(soptAuthRepository: SoptAuthRepository): GetUserInfoUseCase =
        GetUserInfoUseCase(soptAuthRepository = soptAuthRepository)

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
}
