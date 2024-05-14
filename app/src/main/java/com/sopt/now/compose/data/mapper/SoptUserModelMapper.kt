package com.sopt.now.compose.data.mapper

import com.sopt.now.compose.data.model.remote.request.RequestSignUpDto
import com.sopt.now.compose.domain.model.SoptUserModel

fun SoptUserModel.toRequestSignUpDto() = RequestSignUpDto(
    authenticationId = this.authenticationId,
    password = this.password,
    nickname = this.nickname,
    phone = this.phone
)