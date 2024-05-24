package com.sopt.now.data.mapper.remote

import com.sopt.now.data.remote.model.response.ResponseUserInfoDto
import com.sopt.now.domain.model.SoptUserInfoModel

fun ResponseUserInfoDto.toSoptUserInfoEntity() = SoptUserInfoModel(
    authenticationId = this.authenticationId,
    nickname = this.nickname,
    phone = this.phone
)