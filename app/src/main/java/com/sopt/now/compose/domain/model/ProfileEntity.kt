package com.sopt.now.compose.domain.model

data class ProfileEntity(
    val id: Int,
    val profileImage: String,
    val name: String,
    val selfDescription: String? = null
)