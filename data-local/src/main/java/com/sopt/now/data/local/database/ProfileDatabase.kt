package com.sopt.now.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sopt.now.data.local.model.Profile

@Database(entities = [Profile::class], version = 1)
abstract class ProfileDatabase : RoomDatabase() {
    abstract fun profileDao(): com.sopt.now.data.local.dao.ProfileDao
}