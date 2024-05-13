package com.sopt.now.data.mapper.remote

import com.sopt.now.data.remote.model.response.ResponseReqresListUsersDto
import com.sopt.now.domain.model.ReqresUserModel

fun ResponseReqresListUsersDto.ResponseUserDto.toReqresUserEntity() = ReqresUserModel(
    id = this.id,
    email = this.email,
    firstName = this.firstName,
    lastName = this.lastName,
    avatar = this.avatar
)