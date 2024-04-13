package com.sopt.now.di

import com.sopt.now.data.repositoryimpl.SoptRepositoryImpl
import com.sopt.now.domain.repository.SoptRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindsSoptRepository(soptRepositoryImpl: SoptRepositoryImpl): SoptRepository
}
