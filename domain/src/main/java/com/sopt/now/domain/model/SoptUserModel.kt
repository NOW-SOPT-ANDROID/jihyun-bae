package com.sopt.now.domain.model

data class SoptUserModel(
    val authenticationId: String,
    val password: String,
    val nickname: String,
    val phone: String
)