package com.sopt.now.compose.data.mapper

import com.sopt.now.compose.data.model.local.ProfileEntity
import com.sopt.now.compose.domain.model.ProfileModel

fun ProfileModel.toProfile() = ProfileEntity(
    id = this.id,
    profileImage = this.profileImage,
    name = this.name,
    selfDescription = this.selfDescription
)