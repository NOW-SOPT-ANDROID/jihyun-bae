package com.sopt.now.compose.data.database.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sopt.now.compose.data.database.dao.ProfileDao
import com.sopt.now.compose.data.model.local.ProfileEntity

@Database(entities = [ProfileEntity::class], version = 1)
abstract class ProfileDatabase : RoomDatabase() {
    abstract fun profileDao(): ProfileDao
}