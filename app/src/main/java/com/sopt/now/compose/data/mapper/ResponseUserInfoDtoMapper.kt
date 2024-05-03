package com.sopt.now.compose.data.mapper

import com.sopt.now.compose.data.model.remote.response.ResponseUserInfoDto
import com.sopt.now.compose.domain.model.SoptUserInfoEntity

fun ResponseUserInfoDto.toSoptUserInfoEntity() = SoptUserInfoEntity(
    authenticationId = this.authenticationId,
    nickname = this.nickname,
    phone = this.phone
)