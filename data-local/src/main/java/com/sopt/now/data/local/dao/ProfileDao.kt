package com.sopt.now.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.sopt.now.data.local.model.ProfileEntity

@Dao
interface ProfileDao {
    @Query(GET_PROFILE_LIST_QUERY)
    suspend fun getProfileList(): List<ProfileEntity>

    @Insert
    suspend fun insertProfile(profileEntity: ProfileEntity)

    @Delete
    suspend fun deleteProfile(profileEntity: ProfileEntity)

    companion object {
        const val GET_PROFILE_LIST_QUERY = "SELECT * FROM profile_table"
    }
}