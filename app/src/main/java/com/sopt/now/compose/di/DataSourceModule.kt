package com.sopt.now.compose.di

import com.sopt.now.compose.data.datasource.local.ProfileLocalDataSource
import com.sopt.now.compose.data.datasource.local.SoptLocalDataSource
import com.sopt.now.compose.data.datasource.remote.FakeRepoListRemoteDataSource
import com.sopt.now.compose.data.datasource.remote.ReqresRemoteDataSource
import com.sopt.now.compose.data.datasource.remote.SoptRemoteDataSource
import com.sopt.now.compose.data.datasourceimpl.local.ProfileLocalDataSourceImpl
import com.sopt.now.compose.data.datasourceimpl.local.SoptLocalDataSourceImpl
import com.sopt.now.compose.data.datasourceimpl.remote.FakeRepoListRemoteDataSourceImpl
import com.sopt.now.compose.data.datasourceimpl.remote.ReqresRemoteDataSourceImpl
import com.sopt.now.compose.data.datasourceimpl.remote.SoptRemoteDataSourceImpl
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
    abstract fun bindsFakeRepoListRemoteDataSource(fakeRepoListRemoteDataSourceImpl: FakeRepoListRemoteDataSourceImpl): FakeRepoListRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindReqresRemoteDataSource(reqresRemoteDataSourceImpl: ReqresRemoteDataSourceImpl): ReqresRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindsSoptRemoteDataSource(soptRemoteDataSourceImpl: SoptRemoteDataSourceImpl): SoptRemoteDataSource
}