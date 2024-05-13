package com.sopt.now.data.mapper.remote

import com.sopt.now.data.remote.model.response.ResponseFakeReposDto
import com.sopt.now.domain.model.FakeRepoModel

fun ResponseFakeReposDto.toFakeRepoEntity() = FakeRepoModel(
    id = this.id,
    name = this.name,
    description = this.description
)