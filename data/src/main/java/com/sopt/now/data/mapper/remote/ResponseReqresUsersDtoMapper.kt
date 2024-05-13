package com.sopt.now.data.mapper.remote

import com.sopt.now.data.remote.model.response.ResponseReqresUsersDto
import com.sopt.now.domain.model.ReqresUserModel

fun ResponseReqresUsersDto.ResponseUserDto.toReqresUserEntity() = ReqresUserModel(
    id = this.id,
    email = this.email,
    firstName = this.firstName,
    lastName = this.lastName,
    avatar = this.avatar
)