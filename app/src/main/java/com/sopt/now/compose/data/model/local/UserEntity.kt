package com.sopt.now.compose.data.model.local

import com.sopt.now.compose.domain.model.UserModel
import kotlinx.serialization.Serializable

@Serializable
data class UserEntity(
    val id: String,
    val password: String,
    val nickname: String,
    val mbti: String
) {
    fun toUserEntity() = UserModel(
        id = this.id,
        password = this.password,
        nickname = this.nickname,
        mbti = this.mbti
    )
}