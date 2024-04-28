package com.sopt.now.di

import com.sopt.now.data.local.datasource.ProfileLocalDataSource
import com.sopt.now.data.local.datasource.SoptLocalDataSource
import com.sopt.now.data.local.datasourceimpl.ProfileLocalDataSourceImpl
import com.sopt.now.data.local.datasourceimpl.SoptLocalDataSourceImpl
import com.sopt.now.data.remote.datasource.FakeRepoListRemoteDataSource
import com.sopt.now.data.remote.datasourceimpl.FakeRepoListRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    @Singleton
    abstract fun bindsProfileLocalDataSource(profileLocalDataSourceImpl: ProfileLocalDataSourceImpl): ProfileLocalDataSource

    @Binds
    @Singleton
    abstract fun bindsSoptLocalDataSource(soptLocalDataSourceImpl: SoptLocalDataSourceImpl): SoptLocalDataSource

    @Binds
    @Singleton
    abstract fun bindsDummyRemoteDataSource(dummyRemoteDataSourceImpl: FakeRepoListRemoteDataSourceImpl): FakeRepoListRemoteDataSource
}