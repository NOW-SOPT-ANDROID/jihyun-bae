package com.sopt.now.compose.data.mapper

import com.sopt.now.compose.data.model.remote.response.ResponseReqresUsersDto
import com.sopt.now.compose.domain.model.ReqresUserModel

fun ResponseReqresUsersDto.ResponseUserDto.toReqresUserModel() = ReqresUserModel(
    id = this.id,
    email = this.email,
    firstName = this.firstName,
    lastName = this.lastName,
    avatar = this.avatar
)