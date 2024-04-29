package com.sopt.now.compose.di

import android.content.Context
import com.sopt.now.compose.util.AssetLoader
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AssetLoaderModule {
    @Provides
    @Singleton
    fun providesAssetLoader(@ApplicationContext context: Context): AssetLoader =
        AssetLoader(context)
}