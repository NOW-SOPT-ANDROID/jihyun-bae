package com.sopt.now.compose.di

import com.sopt.now.compose.data.datasource.local.SoptLocalDataSource
import com.sopt.now.compose.data.datasourceimpl.local.SoptLocalDataSourceImpl
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
    abstract fun bindsSoptLocalDataSource(soptLocalDataSourceImpl: SoptLocalDataSourceImpl): SoptLocalDataSource
}