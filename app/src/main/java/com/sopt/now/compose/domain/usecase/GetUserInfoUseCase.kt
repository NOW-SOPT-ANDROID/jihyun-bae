package com.sopt.now.compose.domain.usecase

import com.sopt.now.compose.domain.model.SoptUserInfoModel
import com.sopt.now.compose.domain.repository.SoptAuthRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetUserInfoUseCase @Inject constructor(
    private val soptAuthRepository: SoptAuthRepository
) {
    suspend operator fun invoke(memberId: Int): Result<SoptUserInfoModel?> =
        soptAuthRepository.getUserInfo(memberId = memberId)
}