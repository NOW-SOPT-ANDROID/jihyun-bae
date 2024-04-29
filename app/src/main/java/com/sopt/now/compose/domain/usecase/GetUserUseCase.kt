package com.sopt.now.compose.domain.usecase

import com.sopt.now.compose.domain.repository.SoptRepository

class GetUserUseCase(
    private val soptRepository: SoptRepository
) {
    operator fun invoke() = soptRepository.getUser()
}