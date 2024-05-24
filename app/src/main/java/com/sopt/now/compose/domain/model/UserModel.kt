package com.sopt.now.compose.domain.model

data class UserModel(
    val id: String,
    val password: String,
    val nickname: String,
    val mbti: String
)