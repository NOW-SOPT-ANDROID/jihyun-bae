package com.sopt.now.feature.model

data class Profile(
    val profileImage: String,
    val name: String,
    val selfDescription: String? = null
)
