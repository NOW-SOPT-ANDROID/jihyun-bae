package com.sopt.now.data.remote.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseReqresUsersDto(
    @SerialName("page")
    val page: Int,
    @SerialName("per_page")
    val perPage: Int,
    @SerialName("total")
    val total: Int,
    @SerialName("total_pages")
    val totalPages: Int,
    @SerialName("data")
    val data: List<ResponseUserDto>,
    @SerialName("support")
    val responseSupportDto: ResponseSupportDto
) {
    @Serializable
    data class ResponseUserDto(
        @SerialName("id")
        val id: Int,
        @SerialName("email")
        val email: String,
        @SerialName("first_name")
        val firstName: String,
        @SerialName("last_name")
        val lastName: String,
        @SerialName("avatar")
        val avatar: String
    )

    @Serializable
    data class ResponseSupportDto(
        @SerialName("url")
        val url: String,
        @SerialName("text")
        val text: String
    )
}