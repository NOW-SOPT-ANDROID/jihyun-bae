package com.sopt.now.data.mapper.local

import com.sopt.now.data.remote.model.response.ResponseReqresListUsersDto
import com.sopt.now.domain.model.ReqresUserEntity

fun ResponseReqresListUsersDto.ResponseUserDto.toReqresUserEntity() = ReqresUserEntity(
    id = this.id,
    email = this.email,
    firstName = this.firstName,
    lastName = this.lastName,
    avatar = this.avatar
)