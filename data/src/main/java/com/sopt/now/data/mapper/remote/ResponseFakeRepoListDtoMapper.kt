package com.sopt.now.data.mapper.remote

import com.sopt.now.data.remote.model.response.ResponseFakeRepoListDto
import com.sopt.now.domain.model.FakeRepoModel

fun ResponseFakeRepoListDto.toFakeRepoEntity() = FakeRepoModel(
    id = this.id,
    name = this.name,
    description = this.description
)