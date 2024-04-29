package com.sopt.now.compose.domain.usecase

import com.sopt.now.compose.domain.model.UserEntity
import com.sopt.now.compose.domain.repository.SoptRepository

class SetUserUseCase(
    private val soptRepository: SoptRepository
) {
    operator fun invoke(user: UserEntity) = soptRepository.setUser(user = user)
}