package com.sopt.now.compose.di

import com.sopt.now.compose.domain.repository.SoptRepository
import com.sopt.now.compose.domain.usecase.ClearDataSourceUseCase
import com.sopt.now.compose.domain.usecase.GetIsLoginUseCase
import com.sopt.now.compose.domain.usecase.GetUserUseCase
import com.sopt.now.compose.domain.usecase.SetIsLoginUseCase
import com.sopt.now.compose.domain.usecase.SetUserUseCase
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
    fun providesGetIsLoginUseCase(soptRepository: SoptRepository): GetIsLoginUseCase =
        GetIsLoginUseCase(soptRepository = soptRepository)

    @Provides
    @Singleton
    fun providesGetUserUseCase(soptRepository: SoptRepository): GetUserUseCase =
        GetUserUseCase(soptRepository = soptRepository)

    @Provides
    @Singleton
    fun providesSetIsLoginUseCase(soptRepository: SoptRepository): SetIsLoginUseCase =
        SetIsLoginUseCase(soptRepository = soptRepository)

    @Provides
    @Singleton
    fun providesSetUserUseCase(soptRepository: SoptRepository): SetUserUseCase =
        SetUserUseCase(soptRepository = soptRepository)
}