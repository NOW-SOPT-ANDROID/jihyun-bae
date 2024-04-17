package com.sopt.now.data.mapper.remote

import com.sopt.now.data.remote.model.response.ResponseFakeRepoListDto
import com.sopt.now.domain.model.FakeRepoEntity

fun ResponseFakeRepoListDto.toFakeRepoEntity() = FakeRepoEntity(
    id = this.id,
    name = this.name,
    description = this.description
)