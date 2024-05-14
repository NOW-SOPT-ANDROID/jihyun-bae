package com.sopt.now.compose.data.mapper

import com.sopt.now.compose.data.model.remote.response.ResponseUserInfoDto
import com.sopt.now.compose.domain.model.SoptUserInfoModel

fun ResponseUserInfoDto.toSoptUserInfoModel() = SoptUserInfoModel(
    authenticationId = this.authenticationId,
    nickname = this.nickname,
    phone = this.phone
)