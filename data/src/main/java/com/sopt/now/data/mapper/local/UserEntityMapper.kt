package com.sopt.now.data.mapper.local

import com.sopt.now.data.local.model.UserEntity
import com.sopt.now.domain.model.UserModel

fun UserEntity.toUserEntity() = UserModel(
    id = this.id,
    password = this.password,
    nickname = this.nickname,
    mbti = this.mbti
)