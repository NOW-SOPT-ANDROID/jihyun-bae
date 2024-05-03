package com.sopt.now.data.mapper.local

import com.sopt.now.data.remote.model.response.ResponseUserInfoDto
import com.sopt.now.domain.model.SoptUserInfoEntity

fun ResponseUserInfoDto.toSoptUserInfoEntity() = SoptUserInfoEntity(
    authenticationId = this.authenticationId,
    nickname = this.nickname,
    phone = this.phone
)