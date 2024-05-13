package com.sopt.now.data.mapper.local

import com.sopt.now.data.local.model.ProfileEntity
import com.sopt.now.domain.model.ProfileModel

fun ProfileModel.toProfile() = ProfileEntity(
    id = this.id,
    profileImage = this.profileImage,
    name = this.name,
    selfDescription = this.selfDescription
)