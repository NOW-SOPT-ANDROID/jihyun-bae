package com.sopt.now.compose.di

import android.content.Context
import androidx.room.Room
import com.sopt.now.compose.data.database.database.ProfileDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideProfileDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, ProfileDatabase::class.java, "profile_database.db")
            .build()

    @Singleton
    @Provides
    fun provideProfileDao(profileDatabase: ProfileDatabase) =
        profileDatabase.profileDao()
}