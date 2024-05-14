package com.sopt.now.compose.domain.usecase

import com.sopt.now.compose.domain.model.SoptUserEntity
import com.sopt.now.compose.domain.repository.SoptAuthRepository

class PostSignUpUseCase(
    private val soptAuthRepository: SoptAuthRepository
) {
    suspend operator fun invoke(soptUserEntity: SoptUserEntity) =
        soptAuthRepository.postSignUp(soptUserEntity = soptUserEntity)
}