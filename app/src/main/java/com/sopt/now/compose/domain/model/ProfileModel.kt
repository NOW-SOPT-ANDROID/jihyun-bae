package com.sopt.now.compose.domain.model

data class ProfileModel(
    val id: Int = DEFAULT_ID,
    val profileImage: String = DEFAULT_PROFILE_IMAGE,
    val name: String,
    val selfDescription: String? = null
)

private const val DEFAULT_PROFILE_IMAGE = "https://avatars.githubusercontent.com/u/103172971?v=4"
private const val DEFAULT_ID = 0