package com.sopt.now.data.remote.model.response.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse(
    @SerialName("code")
    val code: Int,
    @SerialName("message")
    val message: String
)