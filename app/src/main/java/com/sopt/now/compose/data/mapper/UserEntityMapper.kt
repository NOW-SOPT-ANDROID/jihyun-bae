package com.sopt.now.compose.data.mapper

import com.sopt.now.compose.data.model.local.User
import com.sopt.now.compose.domain.model.UserEntity

fun UserEntity.toUser() = User(
    id = this.id,
    password = this.password,
    nickname = this.nickname,
    mbti = this.mbti
)