package com.sopt.now.di


import com.sopt.now.data.remote.service.DummyService
import com.sopt.now.di.qualifier.Sopt
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
    fun providesDummyService(
        @Sopt retrofit: Retrofit
    ): DummyService =
        retrofit.create(DummyService::class.java)
}
