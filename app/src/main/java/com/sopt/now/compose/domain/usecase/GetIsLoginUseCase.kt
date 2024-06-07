package com.sopt.now.compose.domain.usecase

import com.sopt.now.compose.domain.repository.SoptRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetIsLoginUseCase @Inject constructor(
    private val soptRepository: SoptRepository
) {
    operator fun invoke() : Boolean = soptRepository.getIsLogin()
}