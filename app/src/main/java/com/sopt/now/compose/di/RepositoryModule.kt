package com.sopt.now.compose.di

import com.sopt.now.compose.data.repository.FakeRepoListRepositoryImpl
import com.sopt.now.compose.data.repository.ProfileRepositoryImpl
import com.sopt.now.compose.data.repository.ReqresRepositoryImpl
import com.sopt.now.compose.data.repository.SoptAuthRepositoryImpl
import com.sopt.now.compose.data.repository.SoptRepositoryImpl
import com.sopt.now.compose.domain.repository.FakeReposRepository
import com.sopt.now.compose.domain.repository.ProfileRepository
import com.sopt.now.compose.domain.repository.ReqresRepository
import com.sopt.now.compose.domain.repository.SoptAuthRepository
import com.sopt.now.compose.domain.repository.SoptRepository
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
    abstract fun bindsRepoListRepository(repoListRepositoryImpl: FakeRepoListRepositoryImpl): FakeReposRepository

    @Binds
    @Singleton
    abstract fun bindsReqresRepository(reqresRepositoryImpl: ReqresRepositoryImpl): ReqresRepository

    @Binds
    @Singleton
    abstract fun bindsSoptAuthRepository(soptAuthRepositoryImpl: SoptAuthRepositoryImpl): SoptAuthRepository

    @Binds
    @Singleton
    abstract fun bindsProfileRepository(profileRepositoryImpl: ProfileRepositoryImpl): ProfileRepository

    @Binds
    @Singleton
    abstract fun bindsSoptRepository(soptRepositoryImpl: SoptRepositoryImpl): SoptRepository
}