package com.sopt.now.data.local.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class UserEntity(
    val id: String,
    val password: String,
    val nickname: String,
    val mbti: String
) {
    fun toJsonString() = Json.encodeToString(this)
}