package com.sopt.now.compose.data.model.local

import com.sopt.now.compose.domain.model.UserEntity
import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: String,
    val password: String,
    val nickname: String,
    val mbti: String
) {
    fun toUserEntity() = UserEntity(
        id = this.id,
        password = this.password,
        nickname = this.nickname,
        mbti = this.mbti
    )
}