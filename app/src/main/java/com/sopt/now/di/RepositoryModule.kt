package com.sopt.now.di

import com.sopt.now.data.repositoryimpl.FakeRepoListRepositoryImpl
import com.sopt.now.data.repositoryimpl.ProfileRepositoryImpl
import com.sopt.now.data.repositoryimpl.SoptAuthRepositoryImpl
import com.sopt.now.data.repositoryimpl.SoptRepositoryImpl
import com.sopt.now.domain.repository.FakeRepoListRepository
import com.sopt.now.domain.repository.ProfileRepository
import com.sopt.now.domain.repository.SoptAuthRepository
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
    abstract fun bindsRepoListRepository(repoListRepositoryImpl: FakeRepoListRepositoryImpl): FakeRepoListRepository

    @Binds
    @Singleton
    abstract fun bindsProfileRepository(profileRepositoryImpl: ProfileRepositoryImpl): ProfileRepository

    @Binds
    @Singleton
    abstract fun bindsSoptAuthRepository(soptAuthRepositoryImpl: SoptAuthRepositoryImpl): SoptAuthRepository

    @Binds
    @Singleton
    abstract fun bindsSoptRepository(soptRepositoryImpl: SoptRepositoryImpl): SoptRepository
}
