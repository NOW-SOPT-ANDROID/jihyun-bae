package com.sopt.now.compose.data.mapper

import com.sopt.now.compose.data.model.remote.response.ResponseFakeRepoListDto
import com.sopt.now.compose.domain.model.FakeRepoModel

fun ResponseFakeRepoListDto.toFakeRepoModel() = FakeRepoModel(
    id = this.id,
    name = this.name,
    description = this.description
)