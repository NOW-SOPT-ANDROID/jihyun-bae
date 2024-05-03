package com.sopt.now.compose.data.mapper

import com.sopt.now.compose.data.model.local.Profile
import com.sopt.now.compose.domain.model.ProfileEntity

fun Profile.toProfileEntity() = ProfileEntity(
    id = this.id,
    profileImage = this.profileImage,
    name = this.name,
    selfDescription=this.selfDescription
)