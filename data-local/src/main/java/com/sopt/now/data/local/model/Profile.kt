package com.sopt.now.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "profile_table")
data class Profile(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "profile_image")
    val profileImage: String,
    val name: String,
    @ColumnInfo(name = "self_description")
    val selfDescription: String? = null
)