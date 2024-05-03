package com.sopt.now.compose.domain.usecase

import com.sopt.now.compose.domain.repository.SoptAuthRepository

class GetUserInfoUseCase(
    private val soptAuthRepository: SoptAuthRepository
) {
    suspend operator fun invoke(memberId: Int) =
        soptAuthRepository.getUserInfo(memberId = memberId)
}