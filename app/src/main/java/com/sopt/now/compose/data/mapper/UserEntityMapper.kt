package com.sopt.now.compose.data.mapper

import com.sopt.now.compose.data.model.local.UserEntity
import com.sopt.now.compose.domain.model.UserModel

fun UserModel.toUserEntity() = UserEntity(
    id = this.id,
    password = this.password,
    nickname = this.nickname,
    mbti = this.mbti
)