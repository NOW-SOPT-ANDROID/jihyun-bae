package com.sopt.now.data.mapper.local

import com.sopt.now.data.local.model.ProfileEntity
import com.sopt.now.domain.model.ProfileModel

fun ProfileEntity.toProfileEntity() = ProfileModel(
    id = this.id,
    profileImage = this.profileImage,
    name = this.name,
    selfDescription = this.selfDescription
)