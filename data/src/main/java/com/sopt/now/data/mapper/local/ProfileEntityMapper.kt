package com.sopt.now.data.mapper.local

import com.sopt.now.data.local.model.Profile
import com.sopt.now.domain.model.ProfileEntity

fun ProfileEntity.toProfile() = Profile(
    id = this.id,
    profileImage = this.profileImage,
    name = this.name,
    selfDescription = this.selfDescription
)