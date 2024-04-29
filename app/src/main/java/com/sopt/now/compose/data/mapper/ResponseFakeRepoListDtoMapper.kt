package com.sopt.now.compose.data.mapper

import com.sopt.now.compose.data.model.remote.response.ResponseFakeRepoListDto
import com.sopt.now.compose.domain.model.FakeRepoEntity

fun ResponseFakeRepoListDto.toFakeRepoEntity() = FakeRepoEntity(
    id = this.id,
    name = this.name,
    description = this.description
)