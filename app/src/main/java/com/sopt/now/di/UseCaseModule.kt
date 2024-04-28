package com.sopt.now.di

import com.sopt.now.domain.repository.FakeRepoListRepository
import com.sopt.now.domain.repository.ProfileRepository
import com.sopt.now.domain.usecase.DeleteProfileUseCase
import com.sopt.now.domain.usecase.GetFakeRepoListUseCase
import com.sopt.now.domain.usecase.GetProfileListUseCase
import com.sopt.now.domain.usecase.InsertProfileUseCase
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
    fun providesGetFakeRepoListUseCase(fakeRepoListRepository: FakeRepoListRepository): GetFakeRepoListUseCase =
        GetFakeRepoListUseCase(fakeRepoListRepository = fakeRepoListRepository)

    @Provides
    @Singleton
    fun providesGetProfileListUseCase(profileRepository: ProfileRepository): GetProfileListUseCase =
        GetProfileListUseCase(profileRepository = profileRepository)

    @Provides
    @Singleton
    fun providesInsertProfileUseCase(profileRepository: ProfileRepository): InsertProfileUseCase =
        InsertProfileUseCase(profileRepository = profileRepository)
}
