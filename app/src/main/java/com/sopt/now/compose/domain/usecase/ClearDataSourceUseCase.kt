package com.sopt.now.compose.domain.usecase

import com.sopt.now.compose.domain.repository.SoptRepository

class ClearDataSourceUseCase(
    private val soptRepository: SoptRepository
) {
    operator fun invoke() = soptRepository.clearDataSource()
}