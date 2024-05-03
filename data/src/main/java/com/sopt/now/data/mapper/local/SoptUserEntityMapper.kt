package com.sopt.now.data.mapper.local

import com.sopt.now.data.remote.model.request.RequestSignUpDto
import com.sopt.now.domain.model.SoptUserEntity

fun SoptUserEntity.toRequestSignUpDto() = RequestSignUpDto(
    authenticationId = this.authenticationId,
    password = this.password,
    nickname = this.nickname,
    phone = this.phone
)
