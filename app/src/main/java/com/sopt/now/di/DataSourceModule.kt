package com.sopt.now.di

import com.sopt.now.data.datasource.local.DummyLocalDataSource
import com.sopt.now.data.datasource.remote.DummyRemoteDataSource
import com.sopt.now.data.local.datasourceimpl.DummyLocalDataSourceImpl
import com.sopt.now.data.remote.datasourceimpl.DummyRemoteDataSourceImpl
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
    abstract fun bindsDummyLocalDataSource(dummyLocalDataSourceImpl: DummyLocalDataSourceImpl): DummyLocalDataSource

    @Binds
    @Singleton
    abstract fun bindsDummyRemoteDataSource(dummyRemoteDataSourceImpl: DummyRemoteDataSourceImpl): DummyRemoteDataSource
}
