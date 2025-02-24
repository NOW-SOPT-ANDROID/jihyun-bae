package com.sopt.now.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sopt.now.data.local.dao.ProfileDao
import com.sopt.now.data.local.model.ProfileEntity

@Database(entities = [ProfileEntity::class], version = 1)
abstract class ProfileDatabase : RoomDatabase() {
    abstract fun profileDao(): ProfileDao
}