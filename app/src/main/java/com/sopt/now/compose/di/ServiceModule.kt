package com.sopt.now.compose.di

import com.sopt.now.compose.data.service.ReqresService
import com.sopt.now.compose.data.service.SoptService
import com.sopt.now.compose.di.qualifier.Reqres
import com.sopt.now.compose.di.qualifier.Sopt
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Provides
    @Singleton
    fun providesSoptService(
        @Sopt retrofit: Retrofit
    ): SoptService =
        retrofit.create(SoptService::class.java)

    @Provides
    @Singleton
    fun providesReqresService(
        @Reqres retrofit: Retrofit
    ): ReqresService =
        retrofit.create(ReqresService::class.java)
}