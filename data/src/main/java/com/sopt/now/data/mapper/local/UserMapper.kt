package com.sopt.now.data.mapper.local

import com.sopt.now.data.local.model.User
import com.sopt.now.domain.model.UserEntity

fun User.toUserEntity() = UserEntity(
    id = this.id,
    password = this.password,
    nickname = this.nickname,
    mbti = this.mbti
)