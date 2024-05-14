package com.sopt.now.compose.domain.usecase

import com.sopt.now.compose.domain.repository.SoptRepository

class GetUserIdUseCase(
    private val soptRepository: SoptRepository
) {
    operator fun invoke() : Int = soptRepository.getUserId()
}