package com.sopt.now.domain.usecase

import com.sopt.now.domain.model.SoptUserEntity
import com.sopt.now.domain.repository.SoptAuthRepository

class PostSignUpUseCase(
    private val soptAuthRepository: SoptAuthRepository
) {
    suspend operator fun invoke(soptUserEntity: SoptUserEntity) =
        soptAuthRepository.postSignUp(soptUserEntity = soptUserEntity)
}