package com.sopt.now.compose.domain.model

data class SoptUserEntity(
    val authenticationId: String = "",
    val password: String = "",
    val nickname: String = "",
    val phone: String = ""
)