package com.sopt.now.compose.domain.usecase

import com.sopt.now.compose.domain.repository.SoptRepository

class SetUserIdUseCase(
    private val soptRepository: SoptRepository
) {
    operator fun invoke(userId: Int) = soptRepository.setUserId(userId = userId)
}