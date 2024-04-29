package com.sopt.now.compose.domain.usecase

import com.sopt.now.compose.domain.repository.SoptRepository

class SetIsLoginUseCase(
    private val soptRepository: SoptRepository
) {
    operator fun invoke(isLogin: Boolean) = soptRepository.setIsLogin(isLogin = isLogin)
}