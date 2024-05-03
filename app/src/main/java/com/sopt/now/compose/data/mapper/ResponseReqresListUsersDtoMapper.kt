package com.sopt.now.compose.data.mapper

import com.sopt.now.compose.data.model.remote.response.ResponseReqresListUsersDto
import com.sopt.now.compose.domain.model.ReqresUserEntity

fun ResponseReqresListUsersDto.User.toReqresUserEntity() = ReqresUserEntity(
    id = this.id,
    email = this.email,
    firstName = this.firstName,
    lastName = this.lastName,
    avatar = this.avatar
)