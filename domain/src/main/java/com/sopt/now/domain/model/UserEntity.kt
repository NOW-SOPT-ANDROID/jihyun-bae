package com.sopt.now.domain.model

data class UserEntity(
    val id: String,
    val password: String,
    val nickname: String,
    val mbti: String
)