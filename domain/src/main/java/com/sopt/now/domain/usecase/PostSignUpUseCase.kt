package com.sopt.now.domain.usecase

import com.sopt.now.domain.model.SoptUserModel
import com.sopt.now.domain.repository.SoptAuthRepository

class PostSignUpUseCase(
    private val soptAuthRepository: SoptAuthRepository
) {
    suspend operator fun invoke(soptUserModel: SoptUserModel) =
        soptAuthRepository.postSignUp(soptUserModel = soptUserModel)
}