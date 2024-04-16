package com.sopt.now.data.local.model

import com.sopt.now.domain.model.UserEntity
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class User(
    val id: String,
    val password: String,
    val nickname: String,
    val mbti: String
) {
    fun toJsonString() = Json.encodeToString(this)

    fun toUserEntity() = UserEntity(
        id = this.id,
        password = this.password,
        nickname = this.nickname,
        mbti = this.mbti
    )
}