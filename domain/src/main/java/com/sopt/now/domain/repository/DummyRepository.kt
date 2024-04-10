package com.sopt.now.domain.repository

import com.sopt.now.domain.model.UserEntity

interface DummyRepository {
    suspend fun getDummyUserList(page: Int = 2): Result<List<UserEntity>>
}