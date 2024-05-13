package com.sopt.now.domain.usecase

import com.sopt.now.domain.model.SoptUserInfoModel
import com.sopt.now.domain.repository.SoptAuthRepository

class GetUserInfoUseCase(
    private val soptAuthRepository: SoptAuthRepository
) {
    suspend operator fun invoke(memberId: Int): Result<SoptUserInfoModel?> =
        soptAuthRepository.getUserInfo(memberId = memberId)
}