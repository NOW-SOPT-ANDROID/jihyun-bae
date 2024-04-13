package com.sopt.now.data.mapper

import com.sopt.now.data.model.local.User
import com.sopt.now.domain.model.UserEntity

fun UserEntity.toUser() = User(
    id = this.id,
    password = this.password,
    nickname = this.nickname,
    mbti = this.mbti
)