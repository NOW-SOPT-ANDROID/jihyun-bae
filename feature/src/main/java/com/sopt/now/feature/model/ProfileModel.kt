package com.sopt.now.feature.model

data class ProfileModel(
    val profileImage: String,
    val name: String,
    val selfDescription: String? = null
)
